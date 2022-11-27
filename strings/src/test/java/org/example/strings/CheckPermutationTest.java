package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.Permutation.isPermutation;

public class CheckPermutationTest {

    @Test
    public void equalStringsArePermutations() {
        assertThat(isPermutation("dog", "dog")).isTrue();
    }

    @Test
    public void stringsArePermutations() {
        assertThat(isPermutation("game", "mage")).isTrue();
        assertThat(isPermutation("mage", "game")).isTrue();
    }

    @Test
    @Disabled
    public void sameSizedStringsAreNotPermutations() {
        assertThat(isPermutation("mace", "mage")).isFalse();
        assertThat(isPermutation("mage", "mace")).isFalse();
    }

    @Test
    @Disabled
    public void diffSizedStringsAreNotPermutations() {
        assertThat(isPermutation("mage", "games")).isFalse();
        assertThat(isPermutation("games", "mage")).isFalse();
    }

    @Test
    @Disabled
    public void duplicateLettersThatAreNotPermutations() {
        assertThat(isPermutation("magge", "gaame")).isFalse();
        assertThat(isPermutation("gaame", "magge")).isFalse();
    }

    @Test
    @Disabled
    public void spacesWithEqualsNumberOfSpaces() {
        assertThat(isPermutation("ga me", " mage")).isTrue();
        assertThat(isPermutation(" mage", "ga me")).isTrue();
    }

    @Test
    @Disabled
    public void spacesWithDifferentNumberOfSpaces() {
        assertThat(isPermutation("ga  me", "mage ")).isFalse();
        assertThat(isPermutation("mage ", "ga  me")).isFalse();
    }

}
