package org.example.strings;

public class Compression {
    public static String compress(String str) {
        if (str.length() <= 2) {
            return str;
        }

        var compressed = new StringBuilder();
        var count = 0;
        for (var i = 0; i < str.length(); i++) {
            count++;
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
