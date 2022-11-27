package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.PalindromePermutation.isPalindromePermutation;

public class PalindromePermutationTest {

    @Test
    public void singleWordPalindrome() {
        assertThat(isPalindromePermutation("mama")).isTrue();
    }
    
    @Test
    @Disabled
    public void singleWordNotPalindrome() {
        assertThat(isPalindromePermutation("taco")).isFalse();
    }
}
