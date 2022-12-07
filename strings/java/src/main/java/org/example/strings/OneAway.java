package org.example.strings;

public class OneAway {
    public static boolean evaluate(String candidate, String target) {
        if (Math.abs(candidate.length() - target.length()) > 1) {
            return false;
        }

        return findNumberOfDiff(candidate, target) <= 1;
    }

    public static int findNumberOfDiff(String candidate, String target) {
        var ci = 0;
        var ti = 0;
        var diff = 0;

        while (ci < candidate.length() && ti < target.length()) {

            if (candidate.charAt(ci) == target.charAt(ti)) {
                ci++;
                ti++;
            } else if (candidate.length() > target.length()) {
                ci++;
                diff++;
            } else if (candidate.length() < target.length()) {
                ti++;
                diff++;
            } else {
                ti++;
                ci++;
                diff++;
            }

            if (ti == target.length()) {
                diff += Math.abs(candidate.length() - ci);
            }
        }
        return diff;
    }
}
