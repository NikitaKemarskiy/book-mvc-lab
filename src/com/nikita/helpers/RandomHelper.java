package com.nikita.helpers;

import static java.lang.Math.random;

public class RandomHelper {
    private static String chars = "1234567890abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private RandomHelper() {}

    public static String randomString(int length) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append(chars.charAt((int)(random() * chars.length())));
        }
        return str.toString();
    }
}
