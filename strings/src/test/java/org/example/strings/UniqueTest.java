package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.Unique.*;

public class UniqueTest {

    @Test
    public void noCharactersIsUnique() {
        assertThat(isUnique("")).isTrue();
    }

    @Test
    public void singleCharacterIsUnique() {
        assertThat(isUnique("A")).isTrue();
    }

    @Test
    public void twoDistinctCharactersIsUnique() {
        assertThat(isUnique("AB")).isTrue();
    }

    @Test
    @Disabled
    public void twoIdenticalCharactersNotUnique() {
        assertThat(isUnique("AA")).isFalse();
    }

    @Test
    @Disabled
    public void sameCharacterUpperAndLowerCaseIsUnique() {
        assertThat(isUnique("Aa")).isTrue();
    }

    @Test
    @Disabled
    public void largeStringIsUnique() {
        assertThat(isUnique("Math Problem")).isTrue();
    }

    @Test
    @Disabled
    public void largeStringIsNotUnique() {
        assertThat(isUnique("Math Major")).isFalse();
    }
}
