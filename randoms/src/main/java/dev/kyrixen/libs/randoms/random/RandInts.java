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
 * Utility class for generating random {@code int} values.
 *
 * <p>All methods use a shared {@link Random} instance and are intended for
 * general-purpose random number generation.</p>
 */
public class RandInts {

    // The random generator (random seed)
    private static final Random RANDOM = new Random();

    
    /**
     * Returns a random integer between {@code start} and {@code end}
     * (inclusive).
     *
     * <pre>{@code
     * int value = RandInts.between(5, 10);
     * }</pre>
     *
     * @param start the minimum value (inclusive)
     * @param end the maximum value (inclusive)
     * @return a random integer between {@code start} and {@code end},
     *         or {@code 0} if {@code start > end}
     */
    public static int between(int start, int end) {
        if (start > end) return 0;
        return RANDOM.nextInt(end - start + 1) + start;
    }

    /**
     * Returns a random integer between {@code start} and
     * {@link Integer#MAX_VALUE} (inclusive).
     *
     * <pre>{@code
     * int value = RandInts.from(100);
     * }</pre>
     *
     * @param start the minimum value (inclusive)
     * @return a random integer greater than or equal to
     *         {@code start}
     */
    public static int from(int start) {
        if (start >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return start + RANDOM.nextInt(Integer.MAX_VALUE - start + 1);
    }

    /**
     * Returns a random integer between {@code 0} and {@code end}
     * (inclusive).
     *
     * <pre>{@code
     * int value = RandInts.to(10);
     * }</pre>
     *
     * @param end the maximum value (inclusive)
     * @return a random integer between {@code 0} and {@code end}
     */
    public static int to(int end) {
        return RANDOM.nextInt(end + 1);
    }

}