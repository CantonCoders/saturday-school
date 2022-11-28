package org.example.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.Compression.compress;

public class CompressionTest {

    @Test
    public void emptyStringNotCompressed() {
        assertThat(compress("")).isEqualTo("");
    }

    @Test
    public void compressedStringOfEqualLengthIsNotReturned() {
        assertThat(compress("aa")).isEqualTo("aa");
    }

    @Test
    public void compressSingleCharacter() {
        assertThat(compress("aaa")).isEqualTo("a3");
    }

    @Test
    public void compressedStringIsEqualLengthToTheOriginal() {
        assertThat(compress("aabb")).isEqualTo("aabb");
    }

    @Test
    public void compressTwoSetsOfLetters() {
        assertThat(compress("aaabb")).isEqualTo("a3b2");
    }

    @Test
    public void compressLongString() {
        assertThat(compress("aaabcccccaaa")).isEqualTo("a3b1c5a3");
    }

}
