package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateMatrixTest {

    @Test
    @Disabled
    public void test() {
        //  a, b
        //  c, d
        var matrix = new char[][] { { 'a', 'b' }, { 'c', 'd' } };
        System.out.println(matrix);

        var rotated = new char[][] { { 'c', 'a' }, { 'd', 'b' } };
        assertThat(RotateMatrix.rotate(matrix)).isEqualTo(rotated);
    }
}
