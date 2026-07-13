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
package heightstack.chunk;

import java.util.Objects;


/**
 * Represents the position of a chunk within a terrain.
 * <p>
 * Chunk positions are immutable and are commonly used as keys
 * when storing chunks in maps.
 */
public class ChunkPos {

    // Chunk coordinates
    private final short chunkX;
    private final short chunkY;

    
    /**
     * Creates a new chunk position.
     *
     * @param cx the chunk x-coordinate
     * @param cy the chunk y-coordinate
     */
    public ChunkPos(short cx, short cy) {
        this.chunkX = cx;
        this.chunkY = cy;
    }


    /**
     * Returns the chunk x-coordinate.
     *
     * @return the x-coordinate
     */
    public short cx() {
        return this.chunkX;
    }

    /**
     * Returns the chunk y-coordinate.
     *
     * @return the y-coordinate
     */
    public short cy() {
        return this.chunkY;
    }

    // Override equals to compare chunk positions
    @Override
    public boolean equals(Object o) {
    
        if(this == o) return true;
        if(!(o instanceof ChunkPos)) return false;

        ChunkPos cP = (ChunkPos) o;

        return this.chunkX == cP.chunkX && this.chunkY == cP.chunkY;

    }

    // Override hashcode to hash chunk positions
    @Override
    public int hashCode() {
       return Objects.hash(chunkX, chunkY);
    }

    // Override toString to display chunk positions
    @Override
    public String toString() {
        return "ChunkPos{ x=" + chunkX + ", y=" + chunkY + " }";
    }

}
