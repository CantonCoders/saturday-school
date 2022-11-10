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
        assertThat(checkPermutation("mage", "game")).isTrue();
    }

    @Test
    @Disabled
    public void stringsAreNotPermutations() {
        assertThat(checkPermutation("mage", "games")).isFalse();
    }

    @Test
    @Disabled
    public void spacesWithEqualsNumberOfSpaces() {
        assertThat(checkPermutation(" mage", "ga me")).isTrue();
    }

    @Test
    @Disabled
    public void spacesWithDifferentNumberOfSpaces() {
        assertThat(checkPermutation("mage ", "ga  me")).isFalse();
    }

}
