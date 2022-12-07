package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.strings.Compression.compress;

public class CompressionTest {

    @Test
    public void emptyStringNotCompressed() {
        assertThat(compress("")).isEqualTo("");
    }


}
