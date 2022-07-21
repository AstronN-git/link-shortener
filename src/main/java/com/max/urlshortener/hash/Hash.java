package com.max.urlshortener.hash;

public class Hash {
    public static String hashLongToString(Long l) {
        StringBuilder stringBuilder = new StringBuilder();

        while (l > 0) {
            stringBuilder.append((char) ('a' + (l % 26)));
            l /= 26;
        }

        return stringBuilder.toString();
    }

    public static Long hashStringToLong(String s) {
        long l = 0L;
        long power = 1L;
        for (int i = 0; i < s.length(); i++) {
            l += (s.charAt(i) - 'a') * power;
            power *= 26;
        }

        return l;
    }
}
