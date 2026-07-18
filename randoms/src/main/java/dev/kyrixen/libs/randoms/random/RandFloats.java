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
 * Utility class for generating random {@code float} values.
 *
 * <p>All methods use a shared {@link Random} instance and are intended for
 * general-purpose random number generation.</p>
 */
public class RandFloats {

    // The random number generator (random seed)
    private static final Random RANDOM = new Random();


    /**
     * Returns a random float between {@code start} and {@code end}.
     *
     * <p>Both bounds are inclusive in intent, although due to the nature of
     * floating-point arithmetic the exact upper bound may not always be
     * produced.</p>
     *
     * <pre>{@code
     * RandFloat.between(1.5f, 5.0f);
     * }</pre>
     *
     * @param start the minimum value
     * @param end the maximum value
     * @return a random float between {@code start} and {@code end}, or
     *         {@code 0.0f} if {@code start > end}
     */
    public static float between(float start, float end) {
        if (start > end) return 0.0f;
        return RANDOM.nextFloat() * (end - start) + start;
    }

    /**
     * Returns a random float between {@code start} and {@code 9,999,999}.
     *
     * <pre>{@code
     * RandFloat.from(100.0f);
     * }</pre>
     *
     * @param start the minimum value
     * @return a random float greater than or equal to {@code start}
     */
    public static float from(float start) {
        if (start >= 9999999f) return 9999999f;
        return start + RANDOM.nextFloat() * (9999999f - start);
    }

    /**
     * Returns a random float between {@code 0} and {@code end}.
     *
     * <pre>{@code
     * RandFloat.to(10.0f);
     * }</pre>
     *
     * @param end the maximum value
     * @return a random float between {@code 0} and {@code end}
     */
    public static float to(float end) {
        return RANDOM.nextFloat() * end;
    }

}