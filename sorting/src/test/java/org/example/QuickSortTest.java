package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class QuickSortTest {

    public void testSortArray(int[] array) {
        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        QuickSort.sort(array);
        assertThat(array).isEqualTo(sorted);
    }

    @Test
    public void canSwapTwoNumbers() {
        testSortArray(new int[] { 1, 0 });
    }

    @Test
    public void threeWithNoSwap() {
        testSortArray(new int[] { 0, 1, 2 });
    }

    @Test
    public void threeWithOneSwap() {
        testSortArray(new int[] { 1, 0, 2 });
    }

    @Test
    public void threeWithPivotSwap() {
        testSortArray(new int[] { 2, 0, 1 });
    }

    @Test
    public void fourWithNoSwap() {
        testSortArray(new int[] { 0, 1, 2, 3 });
    }

    @Test
    public void fourWithOneSwap() {
        testSortArray(new int[] { 0, 2, 1, 3 });
    }

    @Test
    public void fourWithTwoSwaps() {
        testSortArray(new int[] { 2, 0, 1, 3 });
    }

    @Test
    public void longEvenLengthArray() {
        testSortArray(new int[] { 5, 9, 2, 0, 8, 1, 4, 7, 3, 6 });
    }

    @Test
    public void longOddLengthArray() {
        testSortArray(new int[] { 5, 9, 2, 0, 8, 1, 4, 7, 3, 6, -1 });
    }
}
