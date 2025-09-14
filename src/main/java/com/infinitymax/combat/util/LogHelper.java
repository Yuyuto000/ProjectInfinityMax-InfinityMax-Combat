package com.infinitymax.combat.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * シンプルログヘルパー
 * 実行環境がForge/Fabricでも使えるよう java.util.logging を使用。
 */
public class LogHelper {
    private static final Logger LOGGER = Logger.getLogger("InfinityMax-Combat");

    public static void info(String msg) {
        LOGGER.log(Level.INFO, "[InfinityMaxCombat] " + msg);
    }

    public static void warn(String msg) {
        LOGGER.log(Level.WARNING, "[InfinityMaxCombat] " + msg);
    }

    public static void error(String msg, Throwable t) {
        LOGGER.log(Level.SEVERE, "[InfinityMaxCombat] " + msg, t);
    }
}
