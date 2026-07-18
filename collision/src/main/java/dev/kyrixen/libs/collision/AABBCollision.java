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
package dev.kyrixen.libs.collision;


/**
 * Utility methods for performing operations on
 * {@link AABB axis-aligned bounding boxes}.
 */
public class AABBCollision {


    /**
     * Checks whether two bounding boxes collide.
     *
     * @param ab1 the first bounding box
     * @param ab2 the second bounding box
     * @return {@code true} if the boxes overlap;
     *         {@code false} otherwise
     */
    public static boolean checkAABBCollision(AABB ab1, AABB ab2) {
        
        return (ab1.x() < ab2.x() + ab2.width() &&
                ab1.x() + ab1.width() > ab2.x() &&
                ab1.y() < ab2.y() + ab2.height() &&
                ab1.y() + ab1.height() > ab2.y());
    
    }    

    /**
     * Determines two bounding boxes distance.
     *
     * @param ab1 the first bounding box
     * @param ab2 the second bounding box
     * @return {@code distance} the boxes distance;
     */
    public static float distance(AABB ab1, AABB ab2) {

        // First box center
        float ab1CenterX = ab1.x() + ab1.width() / 2;
        float ab1CenterY = ab1.y() + ab1.height() / 2;

        // Second box center
        float ab2CenterX = ab2.x() + ab2.width() / 2;
        float ab2CenterY = ab2.y() + ab2.height() / 2;

        // Distance between boxes
        float distX = ab1CenterX - ab2CenterX;
        float distY = ab1CenterY - ab2CenterY;

        // Return distance between boxes
        return (float) Math.sqrt(distX * distX + distY * distY);

    }

}
