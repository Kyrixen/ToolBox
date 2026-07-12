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

package io.kyrixen.tinyblox.world.chunk;

import io.kyrixen.tinyblox.world.chunk.tile.Tile;
import io.kyrixen.tinyblox.world.chunk.tile.TileStack;

public class Chunk<TTile extends Tile> {

    // Chunk cords
    private final ChunkPos chunkPos;

    // Chunk properties
    protected boolean modified;

    // Stores chunk tiles
    protected final TileStack<TTile>[][] chunk;

    @SuppressWarnings("unchecked")
    // Construct chunk
    public Chunk(ChunkPos chunkPos, int w, int h){

        this.chunkPos = chunkPos;

        this.chunk = (TileStack<TTile>[][]) new TileStack[w][h];

        for(byte xPos = 0; xPos < w; xPos++) {
            for(byte yPos = 0; yPos < h; yPos++) {
            
                this.chunk[xPos][yPos] = new TileStack<>();

            }
        }

        this.modified = true;
        
    }


    public short getX(){ return this.chunkPos.cx(); }
    public short getY(){ return this.chunkPos.cy(); }

    public int getWidth() { return chunk.length; }
    public int getHeight() { return chunk[0].length; }

    public void checkIfModified() {

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

    public TileStack<TTile>[][] get() {
        return this.chunk;
    }

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


    public TileStack<TTile> getTileStack(byte localX, byte localY) {
        if(localX < 0 || localX >= getWidth() || localY < 0 || localY >= getHeight()) return null;
        return this.chunk[localX][localY];
    }

    public boolean isModified() { return this.modified; }
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
