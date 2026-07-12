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

import java.util.Objects;

// Chunk position helper
public class ChunkPos {

    private final short chunkX;
    private final short chunkY;
    
    public ChunkPos(short cx, short cy) {
        this.chunkX = cx;
        this.chunkY = cy;
    }

    public short cx() {
        return this.chunkX;
    }

    public short cy() {
        return this.chunkY;
    }

    @Override
    public boolean equals(Object o) {
    
        if(this == o) return true;
        if(!(o instanceof ChunkPos)) return false;

        ChunkPos cP = (ChunkPos) o;

        return this.chunkX == cP.chunkX && this.chunkY == cP.chunkY;

    }

    @Override
    public int hashCode() {
       return Objects.hash(chunkX, chunkY);
    }

    @Override
    public String toString() {
        return "ChunkPos{ x=" + chunkX + ", y=" + chunkY + " }";
    }

}
