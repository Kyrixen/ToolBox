/*
 * Copyright 2026 Kyrixen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.kyrixen.libs.heightstack;

import java.util.HashMap;
import java.util.Map;

import dev.kyrixen.libs.heightstack.chunk.Chunk;
import dev.kyrixen.libs.heightstack.chunk.ChunkPos;
import dev.kyrixen.libs.heightstack.chunk.tile.Tile;
import dev.kyrixen.libs.heightstack.chunk.tile.TileStack;


/**
 * Represents a world composed of chunks containing layered tile stacks.
 * <p>
 * A {@code Terrain} manages chunk storage and provides helper methods
 * for accessing tiles and tile stacks using world coordinates.
 *
 * @param <TTile> the tile type stored in this terrain
 */
public class Terrain<TTile extends Tile> {

    // Dimensions
    private final int worldW, worldH;
    private final int chunkW, chunkH;

    // For storing chunks
    private final HashMap<ChunkPos, Chunk<TTile>> chunks = new HashMap<>();


    /**
     * Creates a new terrain.
     *
     * @param worldW the world width in tiles
     * @param worldH the world height in tiles
     * @param chunkW the width of each chunk in tiles
     * @param chunkH the height of each chunk in tiles
     */
    public Terrain(int worldW, int worldH, int chunkW, int chunkH) {

        this.worldW = worldW;
        this.worldH = worldH;

        this.chunkW = chunkW;
        this.chunkH = chunkH;

    }


    /**
     * Returns the chunk at the specified chunk coordinates.
     *
     * @param cX the chunk x-coordinate
     * @param cY the chunk y-coordinate
     * @return the chunk, or {@code null} if it does not exist
     */
    public Chunk<TTile> getChunk(short cX, short cY) {
        return chunks.get(new ChunkPos(cX, cY));
    }

    /**
     * Returns the tile stack at the specified world coordinates.
     *
     * @param worldX the world x-coordinate
     * @param worldY the world y-coordinate
     * @return the tile stack, or {@code null} if no chunk exists there
     */
    public TileStack<TTile> getWorldTileStack(int worldX, int worldY) {

        short chunkX = (short) Math.floorDiv(worldX, chunkW);
        short chunkY = (short) Math.floorDiv(worldY, chunkH);

        Chunk<TTile> chunk = this.getChunk(chunkX, chunkY);

        if(chunk == null) return null;

        byte localX = (byte) Math.floorMod(worldX, chunkW);
        byte localY = (byte) Math.floorMod(worldY, chunkH);

        return chunk.getTileStack(localX, localY);

    }

    /**
     * Returns the highest occupied level at the specified world coordinates.
     *
     * @param worldX the world x-coordinate
     * @param worldY the world y-coordinate
     * @return the highest tile level, or {@code 0} if no tile exists
     */
    public byte getWorldLevel(int worldX, int worldY) {

        TileStack<TTile> stack = getWorldTileStack(worldX, worldY);

        if(stack == null) return 0;

        TTile top = stack.top();

        if(top == null) return 0;

        return top.level();
    
    }

    
    /**
     * Returns all chunks currently stored in this terrain.
     *
     * @return a map of chunk positions to chunks
     */
    public Map<ChunkPos, Chunk<TTile>> getChunks() { return this.chunks; }


    /**
     * Returns whether a chunk exists at the specified coordinates.
     *
     * @param x the chunk x-coordinate
     * @param y the chunk y-coordinate
     * @return {@code true} if the chunk exists; {@code false} otherwise
     */
    public boolean hasChunk(short x, short y) {
        return chunks.containsKey(new ChunkPos(x, y));
    }

    /**
     * Adds or replaces a chunk in this terrain.
     *
     * @param chunk the chunk to add
     */
    public void addChunk(Chunk<TTile> chunk) {
        chunks.put(new ChunkPos(chunk.getX(), chunk.getY()), chunk);
    }

    /**
     * Removes the chunk at the specified coordinates.
     *
     * @param x the chunk x-coordinate
     * @param y the chunk y-coordinate
     * @return the removed chunk, or {@code null} if no chunk existed
     */
    public Chunk<TTile> removeChunk(short x, short y) {
        return chunks.remove(new ChunkPos(x, y));
    }


    /**
     * Returns the number of chunks along the world's width.
     *
     * @return the horizontal chunk count
     */
    public int getChunkCountX() { return (worldW + chunkW - 1) / chunkW; }

    /**
     * Returns the number of chunks along the world's height.
     *
     * @return the vertical chunk count
     */
    public int getChunkCountY() { return (worldH + chunkH - 1) / chunkH; }

}
