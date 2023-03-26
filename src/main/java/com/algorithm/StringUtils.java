package com.algorithm;

/**
 * Created By Have
 * 2023/3/26 10:50
 */
public class StringUtils {
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean isEmpty(String s) {
        return (s == null || s.length() == 0);
    }
}
