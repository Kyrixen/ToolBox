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
package collision;


/**
 * Represents a 2D axis-aligned bounding box (AABB).
 * <p>
 * An AABB is defined by its top-left position and dimensions.
 * The bounding box is aligned with the coordinate axes and is
 * commonly used for collision detection and spatial queries.
 */
public class AABB {

    // The bouding box coordinates
    private final int x, y;

    // The bounding box dimensions
    private final int w, h;
    
    
    /**
     * Creates a new axis-aligned bounding box.
     *
     * <p>Width and height should be non-negative.
     *
     * @param x x-coordinate of the top-left corner
     * @param y y-coordinate of the top-left corner
     * @param w width of the bounding box
     * @param h height of the bounding box
     */
    public AABB(int x, int y, int w, int h) {
        
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;
    
    }
    

    /**
     * Returns the top-left x-coordinate.
     *
     * @return the x-coordinate
     */
    public int x() { return x; }
    
    /**
     * Returns the top-left y-coordinate.
     *
     * @return the y-coordinate
     */
    public int y() { return y; }


    /**
     * Returns the width.
     *
     * @return the width
     */
    public int width() { return w; }
    
    /**
     * Returns the height.
     *
     * @return the height
     */
    public int height() { return h; }


    // Override equeals method to match the same dimensions and coords
    @Override
    public boolean equals(Object o) {

        if(!(o instanceof AABB)) return false;
        AABB other = (AABB) o;

        return other.x == this.x && other.y == this.y && other.w == this.w && other.h == this.h;

    }

    // Do the same but with hashCode
    @Override
    public int hashCode() {
    
        int result = Integer.hashCode(x);
    
        result = 31 * result + Integer.hashCode(y);
        result = 31 * result + Integer.hashCode(w);
        result = 31 * result + Integer.hashCode(h);
    
        return result;
    
    }

    // Override toString for better readability
    @Override
    public String toString() {
        return "AABB{ x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + " }";
    }

}
