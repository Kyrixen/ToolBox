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

public class ChunkBuilder<TTile extends Tile> {

    private final byte w, h;

    private TileStack<TTile>[][] tilesData;

    
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

    public ChunkBuilder<TTile> setTile(byte tX, byte tY, TTile tile) {
        tilesData[tX][tY].set(tile);
        return this;
    }

    public ChunkBuilder<TTile> fill(TTile tile) {

        for (int tx = 0; tx < this.w; tx++) {
            for (int ty = 0; ty < this.h; ty++) {
        
                tilesData[tx][ty].set(tile);
        
            }
        }

        return this;
    
    }

    public TileStack<TTile>[][] buildData() { return this.tilesData; }

    public Chunk<TTile> buildChunk(ChunkPos chunkPos) {

        Chunk<TTile> finalizedChunk = new Chunk<>(chunkPos, w, h);
        finalizedChunk.set(this.tilesData);

        return finalizedChunk;

    }

}
