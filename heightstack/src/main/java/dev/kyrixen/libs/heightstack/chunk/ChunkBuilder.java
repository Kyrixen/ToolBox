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
package dev.kyrixen.libs.heightstack.chunk;

import dev.kyrixen.libs.heightstack.chunk.tile.Tile;
import dev.kyrixen.libs.heightstack.chunk.tile.TileStack;


/**
 * Builds {@link Chunk chunks} using a fluent API.
 * <p>
 * A {@code ChunkBuilder} allows tile stacks to be populated before
 * constructing the final immutable chunk structure.
 *
 * @param <TTile> the tile type stored in the chunk
 */
public class ChunkBuilder<TTile extends Tile> {

    // Chunk dimensions
    private final byte w, h;

    // Chunk tile stack data
    private TileStack<TTile>[][] tilesData;


    /**
     * Creates a new chunk builder.
     *
     * @param w the chunk width in tile stacks
     * @param h the chunk height in tile stacks
     */
    @SuppressWarnings("unchecked")
    public ChunkBuilder(byte w, byte h) {
        
        this.w = w;
        this.h = h;
        
        tilesData = (TileStack<TTile>[][]) new TileStack[w][h];
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                tilesData[x][y] = new TileStack<>();
            }
        }

    }


    /**
     * Places a tile at the specified local coordinates.
     *
     * @param tX the local x-coordinate
     * @param tY the local y-coordinate
     * @param tile the tile to place
     *
     * @return this builder
     */
    public ChunkBuilder<TTile> setTile(byte tX, byte tY, TTile tile) {
        tilesData[tX][tY].set(tile);
        return this;
    }

    /**
     * Fills every tile stack in the chunk with the specified tile.
     * <p>
     * The same tile instance is inserted into every position.
     *
     * @param tile the tile to place in every stack
     * @return this builder
     */
    public ChunkBuilder<TTile> fill(TTile tile) {

        for (int tx = 0; tx < this.w; tx++) {
            for (int ty = 0; ty < this.h; ty++) {
        
                tilesData[tx][ty].set(tile);
        
            }
        }

        return this;
    
    }


    /**
     * Returns the current tile stack grid.
     *
     * @return the backing tile stack array
     */
    public TileStack<TTile>[][] buildData() { return this.tilesData; }

    /**
     * Builds a new chunk using the current builder contents.
     *
     * @param chunkPos the position of the chunk
     *
     * @return the constructed chunk
     */
    public Chunk<TTile> buildChunk(ChunkPos chunkPos) {

        Chunk<TTile> finalizedChunk = new Chunk<>(chunkPos, w, h);
        finalizedChunk.set(this.tilesData);

        return finalizedChunk;

    }

}
