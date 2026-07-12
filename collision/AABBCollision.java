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

public class AABBCollision {

    // Check AABB collision between entities
    public static boolean checkAABBCollision(AABB ab1, AABB ab2) {
        
        return (ab1.x() < ab2.x() + ab2.width() &&
                ab1.x() + ab1.width() > ab2.x() &&
                ab1.y() < ab2.y() + ab2.height() &&
                ab1.y() + ab1.height() > ab2.y());
    
    }    


    // Checks entity distance
    public static float distance(AABB ab1, AABB ab2) {

        float ab1CenterX = ab1.x() + ab1.width() / 2;
        float ab1CenterY = ab1.y() + ab1.height() / 2;

        float ab2CenterX = ab2.x() + ab2.width() / 2;
        float ab2CenterY = ab2.y() + ab2.height() / 2;

        float distX = ab1CenterX - ab2CenterX;
        float distY = ab1CenterY - ab2CenterY;

        return (float) Math.sqrt(distX * distX + distY * distY);

    }

}
