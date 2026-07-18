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
package dev.kyrixen.libs.randoms.seeded;

import java.util.Random;


/**
 * Generates deterministic random {@code byte} values using a fixed seed.
 *
 * <p>Instances created with the same seed will always produce the same
 * sequence of random values.</p>
 */
public class SeedBytes {

    // The seeded generator (with seed)
    private final Random seededRandom;


    /**
     * Creates a new seeded byte generator.
     *
     * @param seed the seed used to initialize the random number generator
     */
    public SeedBytes(long seed) {
        this.seededRandom = new Random(seed);
    }


    /**
     * Returns a deterministic random byte between {@code start} and {@code end}
     * (inclusive).
     *
     * <pre>{@code
     * SeedBytes random = new SeedBytes(42L);
     * byte value = random.between((byte) 5, (byte) 10);
     * }</pre>
     *
     * @param start the minimum value (inclusive)
     * @param end the maximum value (inclusive)
     * @return a deterministic random byte in the specified range, or
     *         {@code 0} if {@code start > end}
     */
    public byte between(byte start, byte end) {
        if(start > end) return 0;
        return (byte) (seededRandom.nextInt(end - start + 1) + start);
    }        

    /**
     * Returns a deterministic random byte between {@code start} and
     * {@link Byte#MAX_VALUE} (inclusive).
     *
     * <pre>{@code
     * SeedBytes random = new SeedBytes(42L);
     * byte value = random.from((byte) 100);
     * }</pre>
     *
     * @param start the minimum value (inclusive)
     * @return a deterministic random byte greater than or equal to
     *         {@code start}
     */
    public byte from(byte start) {
        if(start >= Byte.MAX_VALUE) return Byte.MAX_VALUE;
        return (byte) (start + seededRandom.nextInt(Byte.MAX_VALUE - start + 1));
    }

    /**
     * Returns a deterministic random byte between {@code 0} and
     * {@code end} (inclusive).
     *
     * <pre>{@code
     * SeedBytes random = new SeedBytes(42L);
     * byte value = random.to((byte) 20);
     * }</pre>
     *
     * @param end the maximum value (inclusive)
     * @return a deterministic random byte between {@code 0} and
     *         {@code end}
     */
    public byte to(byte end) {
        return (byte) seededRandom.nextInt(end + 1);
    }

}
