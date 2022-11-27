package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.PalindromePermutation.isPalindromePermutation;

public class PalindromePermutationTest {

    @Test
    public void singleWordPalindrome() {
        assertThat(isPalindromePermutation("anna")).isTrue();
    }
    
    @Test
    @Disabled
    public void singleWordNotPalindrome() {
        assertThat(isPalindromePermutation("taco")).isFalse();
    }

    @Test
    @Disabled
    public void singleWordPalindromePermutation() {
        assertThat(isPalindromePermutation("nana")).isTrue();
    }

    @Test
    @Disabled
    public void singleWordPalindromePermutationWithOddNumberOfCharacters() {
        assertThat(isPalindromePermutation("nanan")).isTrue();
    }

    @Test
    @Disabled
    public void singleWordWithTwoOddNumberOfCharacters() {
        assertThat(isPalindromePermutation("nanant")).isFalse();
    }

    @Test
    @Disabled
    public void ignoresCase() {
        assertThat(isPalindromePermutation("Racecar")).isTrue();
    }

    @Test
    @Disabled
    public void ignoresSpaces() {
        assertThat(isPalindromePermutation("race car")).isTrue();
    }

    @Test
    @Disabled
    public void ignoresPunctuation() {
        assertThat(isPalindromePermutation("race car!")).isTrue();
    }

    @Test
    @Disabled
    public void ignoresNumbers() {
        assertThat(isPalindromePermutation("race car1")).isTrue();
    }

    @Test
    @Disabled
    public void twoWordPalindromePermutation() {
        assertThat(isPalindromePermutation("#Race & #Care")).isTrue();
    }

}
