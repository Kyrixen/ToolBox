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

package io.kyrixen.tinyblox.collision;


// AABB object class
public class AABB {

    protected final int x, y;
    protected final int w, h;
    
    public AABB(int x, int y, int w, int h) {
        
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    
    }

    public int x() { return x; }
    public int y() { return y; }

    public int width() { return w; }
    public int height() { return h; }

    @Override
    public boolean equals(Object o) {

        if(!(o instanceof AABB)) return false;
        AABB other = (AABB) o;

        return other.x == this.x && other.y == this.y && other.w == this.w && other.h == this.h;

    }

    @Override
    public int hashCode() {
    
        int result = Integer.hashCode(x);
    
        result = 31 * result + Integer.hashCode(y);
        result = 31 * result + Integer.hashCode(w);
        result = 31 * result + Integer.hashCode(h);
    
        return result;
    
    }

    @Override
    public String toString() {
        return "AABB{ x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + " }";
    }

}
