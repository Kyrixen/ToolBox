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
 * Generates deterministic random {@code float} values using a fixed seed.
 *
 * <p>Instances created with the same seed will always produce the same
 * sequence of random values.</p>
 */
public class SeedFloats {
    
    // The seeded generator (with seed)
    private final Random seededRandom;

    // Max float constant
    private static final float MAX_FLOAT = 9999999f;


    /**
     * Creates a new seeded float generator.
     *
     * @param seed the seed used to initialize the random number generator
     */
    public SeedFloats(long seed) {
        this.seededRandom = new Random(seed);
    }


    /**
     * Returns a deterministic random float between {@code start} and
     * {@code end}.
     *
     * <pre>{@code
     * SeedFloats random = new SeedFloats(42L);
     * float value = random.between(1.5f, 5.0f);
     * }</pre>
     *
     * @param start the minimum value
     * @param end the maximum value
     * @return a deterministic random float between {@code start} and
     *         {@code end}, or {@code 0.0f} if {@code start > end}
     */
    public float between(float start, float end) {
        if(start > end) return 0.0f;
        return seededRandom.nextFloat() * (end - start) + start;
    }

    /**
     * Returns a deterministic random float between {@code start} and
     * {@code 9,999,999}.
     *
     * <pre>{@code
     * SeedFloats random = new SeedFloats(42L);
     * float value = random.from(100.0f);
     * }</pre>
     *
     * @param start the minimum value
     * @return a deterministic random float greater than or equal to
     *         {@code start}
     */
    public float from(float start) {
        if(start >= MAX_FLOAT) return MAX_FLOAT;
        return start + seededRandom.nextFloat() * (MAX_FLOAT - start);
    }

    /**
     * Returns a deterministic random float between {@code 0} and
     * {@code end}.
     *
     * <pre>{@code
     * SeedFloats random = new SeedFloats(42L);
     * float value = random.to(10.0f);
     * }</pre>
     *
     * @param end the maximum value
     * @return a deterministic random float between {@code 0} and
     *         {@code end}
     */
    public float to(float end) {
        return seededRandom.nextFloat() * end;
    }

}
