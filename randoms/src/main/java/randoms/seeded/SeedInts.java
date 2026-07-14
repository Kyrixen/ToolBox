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
 * Generates deterministic random {@code int} values using a fixed seed.
 *
 * <p>Instances created with the same seed will always produce the same
 * sequence of random values.</p>
 */
public class SeedInts {

    // The seeded generator (with seed)
    private final Random seededRandom;


    /**
     * Creates a new seeded integer generator.
     *
     * @param seed the seed used to initialize the random number generator
     */
    public SeedInts(long seed) {
        this.seededRandom = new Random(seed);
    }


    /**
     * Returns a deterministic random integer between {@code start} and
     * {@code end} (inclusive).
     *
     * <pre>{@code
     * SeedInts random = new SeedInts(42L);
     * int value = random.between(5, 10);
     * }</pre>
     *
     * @param start the minimum value (inclusive)
     * @param end the maximum value (inclusive)
     * @return a deterministic random integer between {@code start} and
     *         {@code end}, or {@code 0} if {@code start > end}
     */
    public int between(int start, int end) {
        if (start > end) return 0;
        return seededRandom.nextInt(end - start + 1) + start;
    }

    /**
     * Returns a deterministic random integer between {@code start} and
     * {@link Integer#MAX_VALUE} (inclusive).
     *
     * <pre>{@code
     * SeedInts random = new SeedInts(42L);
     * int value = random.from(100);
     * }</pre>
     *
     * @param start the minimum value (inclusive)
     * @return a deterministic random integer greater than or equal to
     *         {@code start}
     */
    public int from(int start) {
        if (start >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return start + seededRandom.nextInt(Integer.MAX_VALUE - start + 1);
    }

    /**
     * Returns a deterministic random integer between {@code 0} and
     * {@code end} (inclusive).
     *
     * <pre>{@code
     * SeedInts random = new SeedInts(42L);
     * int value = random.to(10);
     * }</pre>
     *
     * @param end the maximum value (inclusive)
     * @return a deterministic random integer between {@code 0} and
     *         {@code end}
     */
    public int to(int end) {
        return seededRandom.nextInt(end + 1);
    }

}