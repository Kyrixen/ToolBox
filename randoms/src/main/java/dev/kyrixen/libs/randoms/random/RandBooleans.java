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
package dev.kyrixen.libs.randoms.random;

import java.util.Random;


/**
 * Utility class for generating random boolean values.
 *
 * <p>All methods use a shared {@link Random} instance and are intended for
 * general-purpose random number generation.</p>
 */
public class RandBooleans {
    
    // The random generator (random seed)
    private final static Random RANDOM = new Random();

    
    /**
     * Returns {@code true} with the specified probability.
     *
     * <p>A chance of {@code 0.0f} will always return {@code false}, while
     * {@code 1.0f} will always return {@code true}.</p>
     *
     * <pre>{@code
     * RandBoolean.randomBoolean(0.25f); // 25% chance of true
     * }</pre>
     *
     * @param chance the probability of returning {@code true}, from {@code 0.0f} to {@code 1.0f}
     * @return {@code true} with the given probability; otherwise {@code false}
     */    
    public static boolean chance(float chance) {
        if(chance < 0.0f || chance > 1.0f) throw new IllegalArgumentException("Chance value must be between 0.0 and 1.0");
        return RANDOM.nextFloat() < chance;
    }
    
    /**
     * Returns a random boolean value.
     *
     * <pre>{@code
     * RandBoolean.randomBoolean();
     * }</pre>
     *
     * @return a random boolean value
     */
    public static boolean value() {
        return RANDOM.nextBoolean();
    }

}
