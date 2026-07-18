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
 * Represents a chunk containing a fixed-size grid of {@link TileStack tile stacks}.
 * <p>
 * Chunks partition a {@link dev.kyrixen.libs.heightstack.Terrain Terrain} into smaller regions,
 * allowing efficient storage and access to layered terrain.
 *
 * @param <TTile> the tile type stored in this chunk
 */
public class Chunk<TTile extends Tile> {

    // Chunk cords
    private final ChunkPos chunkPos;

    // Chunk properties
    private boolean modified;

    // Stores chunk tiles
    private final TileStack<TTile>[][] chunk;


    /**
     * Creates a new chunk with the specified dimensions.
     * <p>
     * Every position in the chunk is initialized with an empty
     * {@link TileStack}.
     *
     * @param chunkPos the position of the chunk
     * @param w the chunk width in tile stacks
     * @param h the chunk height in tile stacks
     */
    @SuppressWarnings("unchecked")
    public Chunk(ChunkPos chunkPos, int w, int h) {

        this.chunkPos = chunkPos;

        this.chunk = (TileStack<TTile>[][]) new TileStack[w][h];

        for(byte xPos = 0; xPos < w; xPos++) {
            for(byte yPos = 0; yPos < h; yPos++) {
            
                this.chunk[xPos][yPos] = new TileStack<>();

            }
        }

        this.modified = true;
        
    }


    /**
     * Returns the chunk x-coordinate.
     *
     * @return the chunk x-coordinate
     */
    public short getX(){ return this.chunkPos.cx(); }
    
    /**
     * Returns the chunk y-coordinate.
     *
     * @return the chunk y-coordinate
     */
    public short getY(){ return this.chunkPos.cy(); }

    /**
     * Returns the width of this chunk.
     *
     * @return the width in tile stacks
     */
    public int getWidth() { return chunk.length; }

    /**
     * Returns the height of this chunk.
     *
     * @return the height in tile stacks
     */
    public int getHeight() { return chunk[0].length; }


    /**
     * Returns the tile stack at the specified local coordinates.
     *
     * @param localX the local x-coordinate
     * @param localY the local y-coordinate
     *
     * @return the tile stack, or {@code null} if the coordinates are outside
     *         this chunk
     */
    public TileStack<TTile> getTileStack(byte localX, byte localY) {
        if(localX < 0 || localX >= getWidth() || localY < 0 || localY >= getHeight()) return null;
        return this.chunk[localX][localY];
    }

    /**
     * Returns the backing tile stack grid.
     *
     * @return the two-dimensional tile stack array
     */
    public TileStack<TTile>[][] getStacks() {
        return this.chunk;
    }

    /**
     * Replaces the contents of this chunk.
     * <p>
     * Tile stacks are copied into the existing chunk rather than
     * replacing the backing array.
     *
     * @param tiles the tile stack grid to copy
     *
     * @throws IllegalArgumentException if the array dimensions do not
     *         match this chunk's dimensions
     */
    public void set(TileStack<TTile>[][] tiles) {
    
        if (tiles == null) return;
        if(tiles.length != getWidth() || tiles[0].length != getHeight()) throw new IllegalArgumentException("Size of tiles array must be same as chunk size");
    
        for(byte xPos = 0; xPos < tiles.length; xPos++) {
            for(byte yPos = 0; yPos < tiles[0].length; yPos++) {
                chunk[xPos][yPos] = new TileStack<TTile>();
            }
        }

        for(byte localX = 0; localX < tiles.length; localX++) {
            for(byte localY = 0; localY < tiles[0].length; localY++) {

                TileStack<TTile> sourceStack = tiles[localX][localY];

                TileStack<TTile> currentStack = this.getTileStack(localX, localY);

                if(sourceStack == null) continue;

                for(byte level = 0; level < sourceStack.capacity(); level++) {

                    TTile tile = sourceStack.get(level);

                    if(tile == null) continue;

                    currentStack.set(tile);

                }

            }
        }
    
        modified = true;

    }


    /**
     * Recalculates the modified state of this chunk.
     * <p>
     * The chunk is considered modified if any contained
     * {@link TileStack} has been modified.
     */
    public void updateModifiedState() {

        this.modified = false;

        for(byte xPos = 0; xPos < getWidth(); xPos++) {
            for(byte yPos = 0; yPos < getHeight(); yPos++) {

                TileStack<TTile> tileStack = this.chunk[xPos][yPos];
                if(tileStack == null) continue;

                if(tileStack.isModified()) this.modified = true;

                if(this.modified) return;

            }
        }

    }

    
    /**
     * Returns whether this chunk has been modified.
     *
     * @return {@code true} if modified; {@code false} otherwise
     */
    public boolean isModified() { return this.modified; }

    /**
     * Sets the modified state of this chunk and all contained tile stacks.
     *
     * @param modified the new modified state
     */
    public void setModified(boolean modified) { 
        
        this.modified = modified; 
        
        for(byte xPos = 0; xPos < getWidth(); xPos++) {
            for(byte yPos = 0; yPos < getHeight(); yPos++) {

                TileStack<TTile> tileStack = this.chunk[xPos][yPos];
                if(tileStack == null) continue;

                tileStack.setModified(modified);

            }
        }
    
    }

}
