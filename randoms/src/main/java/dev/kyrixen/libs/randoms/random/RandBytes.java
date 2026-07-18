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
 * Utility class for generating random {@code byte} values.
 *
 * <p>All methods use a shared {@link Random} instance and are intended for
 * general-purpose random number generation.</p>
 */
public class RandBytes {

    // The random generator (random seed)
    private final static Random RANDOM = new Random();


    /**
     * Returns a random byte between {@code start} and {@code end} (inclusive).
     *
     * <pre>{@code
     * RandByte.between((byte) 5, (byte) 10);
     * }</pre>
     *
     * @param start the minimum value (inclusive)
     * @param end the maximum value (inclusive)
     * @return a random byte in the specified range, or {@code 0} if
     *         {@code start > end}
     */
    public static byte between(byte start, byte end) {
        if(start > end) return 0;
        return (byte) (RANDOM.nextInt(end - start + 1) + start);
    }

    /**
     * Returns a random byte between {@code start} and
     * {@link Byte#MAX_VALUE} (inclusive).
     *
     * <pre>{@code
     * RandByte.from((byte) 100);
     * }</pre>
     *
     * @param start the minimum value (inclusive)
     * @return a random byte greater than or equal to {@code start}
     */
    public static byte from(byte start) {
        if(start >= Byte.MAX_VALUE) return Byte.MAX_VALUE;
        return (byte) (start + RANDOM.nextInt(Byte.MAX_VALUE - start + 1));
    }

    /**
     * Returns a random byte between {@code 0} and {@code end} (inclusive).
     *
     * <pre>{@code
     * RandByte.to((byte) 50);
     * }</pre>
     *
     * @param end the maximum value (inclusive)
     * @return a random byte between {@code 0} and {@code end}
     */
    public static byte to(byte end) {
        return (byte) RANDOM.nextInt(end + 1);
    }

}
