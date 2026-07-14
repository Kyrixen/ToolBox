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
package randoms.seeded;

import java.util.Random;


/**
 * Generates deterministic random {@code boolean} values using a fixed seed.
 *
 * <p>Instances created with the same seed will always produce the same
 * sequence of random values.</p>
 */
public class SeedBooleans {

    // The seeded generator (with seed)
    private final Random seededRandom;


    /**
     * Creates a new seeded boolean generator.
     *
     * @param seed the seed used to initialize the random number generator
     */
    public SeedBooleans(long seed) {
        this.seededRandom = new Random(seed);
    }


    /**
     * Returns {@code true} with the specified probability.
     *
     * <p>For the same seed and sequence of calls, this method will always
     * produce the same results.</p>
     *
     * <pre>{@code
     * SeedBooleans random = new SeedBooleans(42);
     * random.chance(0.25f); // 25% chance of true
     * }</pre>
     *
     * @param chance the probability of returning {@code true},
     *               from {@code 0.0f} to {@code 1.0f}
     * @return {@code true} with the given probability
     * @throws IllegalArgumentException if {@code chance} is outside the range
     *                                  {@code 0.0f} to {@code 1.0f}
     */
    public boolean chance(float chance) {
        if(chance < 0.0f || chance > 1.0f) throw new IllegalArgumentException("Chance value must be between 0.0f and 1.0f (inclusive)");
        return seededRandom.nextFloat() < chance;
    }

    /**
     * Returns a deterministic random boolean value.
     *
     * <pre>{@code
     * SeedBooleans random = new SeedBooleans(42);
     * random.value();
     * }</pre>
     *
     * @return a deterministic random boolean value
     */
    public boolean value() {
        return seededRandom.nextBoolean();
    }

}
