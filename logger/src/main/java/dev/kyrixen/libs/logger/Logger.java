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
package dev.kyrixen.libs.logger;


/**
 * A lightweight console logger with optional debug output and ANSI colors.
 * <p>
 * Messages are written to the standard output stream and categorized
 * by severity and user-defined categories.
 */
public class Logger {

    /**
     * Shared logger instance.
     */
    public static final Logger LOGGER = new Logger();

    // Current color holder
    private static LoggerColor CURRENT_COLOR = LoggerColor.RESET;

    // Debug state
    private boolean debug = false;


    // Prevent instancing logger
    private Logger() {}


    /**
     * Prints a message using the currently selected color.
     *
     * @param text the text to print
     */
    public void print(String text) {
        System.out.println(CURRENT_COLOR + text + LoggerColor.RESET);
    }


    /**
     * Logs an informational message.
     *
     * @param category the message category
     * @param text the message to log
     */
    public void info(String category, String text) {
        System.out.println(LoggerColor.BLUE + "[INFO] " + LoggerColor.AQUA + "[" + category + "] " + LoggerColor.RESET + text);
    }

    /**
     * Logs a warning message.
     *
     * @param category the message category
     * @param text the message to log
     */
    public void warn(String category, String text) {
        System.out.println(LoggerColor.BLUE + "[WARN] " + LoggerColor.AQUA + "[" + category + "] " + LoggerColor.YELLOW + text + LoggerColor.RESET);
    }

    /**
     * Logs an error message.
     *
     * @param category the message category
     * @param text the message to log
     */
    public void error(String category, String text) {
        System.out.println(LoggerColor.BLUE + "[ERROR] " + LoggerColor.AQUA + "[" + category + "] " + LoggerColor.RESET + LoggerColor.RED + text + LoggerColor.RESET);
    }

    /**
     * Logs a debug message if debug mode is enabled.
     *
     * @param category the message category
     * @param text the message to log
     */
    public void debug(String category, String text) {
        if(!debug) return;
        System.out.println(LoggerColor.BLUE + "[DEBUG] " + LoggerColor.AQUA + "[" + category + "] " + LoggerColor.RESET + LoggerColor.GRAY + text + LoggerColor.RESET);
    }


    /**
     * Sets the color used by {@link #print(String)}.
     *
     * @param color the new output color
     */
    public void setCurrentColor(LoggerColor color) {
        CURRENT_COLOR = color;
    }

    /**
     * Returns the currently selected output color.
     *
     * @return the current color
     */
    public LoggerColor getCurrentColor() { return CURRENT_COLOR; }


    /**
     * Returns whether debug logging is enabled.
     *
     * @return {@code true} if debug logging is enabled;
     *         {@code false} otherwise
     */
    public boolean debugActive() { return debug; }

    /**
     * Enables or disables debug logging.
     *
     * @param debugState {@code true} to enable debug messages;
     *                   {@code false} to disable them
     */
    public void setDebug(boolean debugState) {
        this.debug = debugState;
    }

}
