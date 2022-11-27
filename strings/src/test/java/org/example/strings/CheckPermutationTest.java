package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.StringProperties.checkPermutation;

public class CheckPermutationTest {

    @Test
    public void equalStringsArePermutations() {
        assertThat(checkPermutation("dog", "dog")).isTrue();
    }

    @Test
    public void stringsArePermutations() {
        assertThat(checkPermutation("game", "mage")).isTrue();
        assertThat(checkPermutation("mage", "game")).isTrue();
    }

    @Test
    @Disabled
    public void sameSizedStringsAreNotPermutations() {
        assertThat(checkPermutation("mace", "mage")).isFalse();
        assertThat(checkPermutation("mage", "mace")).isFalse();
    }

    @Test
    @Disabled
    public void diffSizedStringsAreNotPermutations() {
        assertThat(checkPermutation("mage", "games")).isFalse();
        assertThat(checkPermutation("games", "mage")).isFalse();
    }

    @Test
    @Disabled
    public void duplicateLettersThatAreNotPermutations() {
        assertThat(checkPermutation("magge", "gaame")).isFalse();
        assertThat(checkPermutation("gaame", "magge")).isFalse();
    }

    @Test
    @Disabled
    public void spacesWithEqualsNumberOfSpaces() {
        assertThat(checkPermutation("ga me", " mage")).isTrue();
        assertThat(checkPermutation(" mage", "ga me")).isTrue();
    }

    @Test
    @Disabled
    public void spacesWithDifferentNumberOfSpaces() {
        assertThat(checkPermutation("ga  me", "mage ")).isFalse();
        assertThat(checkPermutation("mage ", "ga  me")).isFalse();
    }

}
