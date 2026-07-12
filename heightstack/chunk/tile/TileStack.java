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

package io.kyrixen.tinyblox.world.chunk.tile;

import java.util.ArrayList;
import java.util.List;

// Tile stack (used for storing)
public class TileStack<TTile extends Tile>  {

    private final List<TTile> tiles;

    private boolean modified = true;

    public TileStack(List<TTile> tiles) {
        this.tiles = tiles;
    }

    public TileStack() {
        this.tiles = new ArrayList<>();
    }

    public byte capacity() {
        return (byte) tiles.size();
    }

    public byte height() {

        TTile top = this.top();
        if(top == null) return 0;

        return (byte) (top.level() + 1);

    }

    public TTile top() {

        for(int i = tiles.size() - 1; i >= 0; i--) {

            TTile tile = tiles.get(i);
            if(tile == null) continue;

            return tile;

        }

        return null;

    }

    public TTile bottom() {

        for(int i = 0; i < tiles.size(); i++) {

            TTile tile = tiles.get(i);
            if(tile == null) continue;

            return tile;

        }

        return null;

    }

    public void removeAtLayer(byte level) {

        if(level < 0 || level >= this.tiles.size()) return;

        TTile tile = this.tiles.get(level);
        if(tile == null) return;

        this.tiles.set(level, null);

        this.modified = true;

    }

    public void set(TTile tile) {

        while(this.tiles.size() <= tile.level()) { this.tiles.add(null); }
        this.tiles.set(tile.level(), tile);

        this.modified = true;
        
    }

    public TTile get(byte level) {

        if(level < 0 || level >= tiles.size()) return null;
        return tiles.get(level);

    }

    public boolean isEmpty() {

        for(TTile tile : tiles) {
            if(tile == null) continue;
            return false;
        }
        
        return true;

    }

    // Get and Set modified state
    public boolean isModified() { return this.modified; }
    public void setModified(boolean modified) { this.modified = modified; }

}
