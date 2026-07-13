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
package heightstack.chunk.tile;


/**
 * Represents a single tile within a {@link TileStack}.
 * <p>
 * {@code Tile} stores its elevation level and may be extended
 * to hold additional data such as terrain type, metadata,
 * or game-specific properties.
 */
public class Tile {

    // Terrain height
    private final byte level;


    /**
     * Creates a new tile.
     *
     * <p>The level should be non-negative.
     *
     * @param level the elevation level of the tile within a {@link TileStack}
     */
    public Tile(byte level) {
        this.level = level;
    }
    

    /**
     * Returns the tile level.
     *
     * @return the level
     */
    public byte level() { return level; }


    // Override toString for better readability
    @Override
    public String toString() {
        return "Tile{ level=" + level + " }";
    }

}
