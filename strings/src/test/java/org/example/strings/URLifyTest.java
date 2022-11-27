package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class URLifyTest {
    
    @Test
    public void containsNoSpaces() {
        testReplaceSpaces("Coding", "Coding");
    }

    @Test
    @Disabled
    public void containsSingleSpace() {
        testReplaceSpaces("Canton Coders", "Canton%20Coders");
    }

    @Test
    @Disabled
    public void containsMultipleSpaces() {
        testReplaceSpaces("Coding with Canton Coders", "Coding%20with%20Canton%20Coders");
    }

    private static void testReplaceSpaces(String input, String output) {
        var inputArray = Arrays.copyOf(input.toCharArray(), output.length());
        Arrays.fill(inputArray, input.length(), output.length(), ' ');

        Urlify.replaceSpaces(inputArray);
        assertThat(inputArray).isEqualTo(output.toCharArray());
    }
}
