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
package logger;


/**
 * ANSI terminal colors supported by {@link Logger}.
 */
public enum LoggerColor {

    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    AQUA("\u001B[96m"),
    GRAY("\u001B[90m"),
    BLUE("\u001B[34m");


    // The color string
    private final String color;


    // Constructs enum
    LoggerColor(String color) {
        this.color = color;
    }


    /**
     * Returns the ANSI escape sequence.
     *
     * @return the ANSI color code
     */
    @Override
    public String toString() { return this.color; }

}