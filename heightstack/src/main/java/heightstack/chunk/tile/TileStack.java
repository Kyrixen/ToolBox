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

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a stack of {@link Tile tiles} ordered by elevation.
 * <p>
 * A {@code TileStack} stores tiles at different levels, allowing
 * multiple layers to occupy the same world position.
 *
 * @param <TTile> the tile type stored in this stack
 */
public class TileStack<TTile extends Tile>  {

    // List of the tiles
    private final List<TTile> tiles;

    // Modified flag
    private boolean modified = true;


    /**
     * Creates a tile stack using the specified backing list.
     *
     * @param tiles the initial tile storage
     */
    public TileStack(List<TTile> tiles) {
        this.tiles = tiles;
    }

    /**
     * Creates an empty tile stack.
     */
    public TileStack() {
        this.tiles = new ArrayList<>();
    }


    /**
     * Returns the current storage capacity of this stack.
     * <p>
     * This is the number of levels currently allocated,
     * including empty ({@code null}) entries.
     *
     * @return the current capacity
     */
    public byte capacity() {
        return (byte) tiles.size();
    }

    /**
     * Returns the height of the stack.
     * <p>
     * The height is equal to the highest occupied level plus one.
     *
     * @return the stack height
     */
    public byte height() {

        TTile top = this.top();
        if(top == null) return 0;

        return (byte) (top.level() + 1);

    }


    /**
     * Returns the highest non-null tile.
     *
     * @return the highest tile, or {@code null} if the stack is empty
     */
    public TTile top() {

        for(int i = tiles.size() - 1; i >= 0; i--) {

            TTile tile = tiles.get(i);
            if(tile == null) continue;

            return tile;

        }

        return null;

    }

    /**
     * Returns the lowest non-null tile.
     *
     * @return the lowest tile, or {@code null} if the stack is empty
     */
    public TTile bottom() {

        for(int i = 0; i < tiles.size(); i++) {

            TTile tile = tiles.get(i);
            if(tile == null) continue;

            return tile;

        }

        return null;

    }

    
    /**
     * Removes the tile at the specified level.
     *
     * @param level the level to remove
     */
    public void removeAtLayer(byte level) {

        if(level < 0 || level >= this.tiles.size()) return;

        TTile tile = this.tiles.get(level);
        if(tile == null) return;

        this.tiles.set(level, null);

        this.modified = true;

    }

    /**
     * Places a tile into the stack.
     * <p>
     * The stack automatically expands if necessary.
     *
     * @param tile the tile to insert
     */
    public void set(TTile tile) {

        while(this.tiles.size() <= tile.level()) { this.tiles.add(null); }
        this.tiles.set(tile.level(), tile);

        this.modified = true;
        
    }

    /**
     * Gets {@link Tile} at selected level.
     * 
     *@param level the tile level
     
     *@return the {@link TTile} 
     * 
     */
    public TTile get(byte level) {

        if(level < 0 || level >= tiles.size()) return null;
        return tiles.get(level);

    }


    /**
     * Returns whether this stack contains any tiles.
     *
     * @return {@code true} if the stack contains no tiles;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {

        for(TTile tile : tiles) {
            if(tile == null) continue;
            return false;
        }
        
        return true;

    }

    /**
     * Returns whether this stack has been modified.
     *
     * @return {@code true} if modified; {@code false} otherwise
     */
    public boolean isModified() { return this.modified; }

    /**
     * Sets the modified state of this stack.
     *
     * @param modified the new modified state
     */
    public void setModified(boolean modified) { this.modified = modified; }

}
