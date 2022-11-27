package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.Permutation.isPermutation;

public class PermutationTest {

    @Test
    public void equalStringsArePermutations() {
        assertThat(isPermutation("dog", "dog")).isTrue();
    }

    @Test
    public void permutationAllowsSpaces() {
        assertThat(isPermutation("my dog", "my dog")).isTrue();
    }

    @Test
    @Disabled
    public void permutationIsCaseSensitive() {
        assertThat(isPermutation("dog", "Dog")).isFalse();
    }

    @Test
    @Disabled
    public void permutationsAreEqualInLength() {
        assertThat(isPermutation("game", "games")).isFalse();
        assertThat(isPermutation("games", "game")).isFalse();
    }

    @Test
    @Disabled
    public void sameSizedStringsAreNotPermutations() {
        assertThat(isPermutation("mace", "mage")).isFalse();
        assertThat(isPermutation("mage", "mace")).isFalse();
    }

    @Test
    @Disabled
    public void permutationOfUnequalStrings() {
        assertThat(isPermutation("game", "mage")).isTrue();
        assertThat(isPermutation("mage", "game")).isTrue();
    }

    @Test
    @Disabled
    public void duplicateLettersThatAreNotPermutations() {
        assertThat(isPermutation("magge", "gaame")).isFalse();
        assertThat(isPermutation("gaame", "magge")).isFalse();
    }

    @Test
    @Disabled
    public void spacesWithUnequalNumberOfSpaces() {
        assertThat(isPermutation("ga  me", "mage ")).isFalse();
        assertThat(isPermutation("mage ", "ga  me")).isFalse();
    }

}
