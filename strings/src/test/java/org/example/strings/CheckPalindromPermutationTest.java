package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.StringProperties.isPalindromePermutation;

public class CheckPalindromPermutationTest {

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
