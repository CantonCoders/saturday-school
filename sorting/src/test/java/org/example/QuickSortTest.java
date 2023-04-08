package org.example;

import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] array = { 5, 4, 3, 2, 1 };
        QuickSort.sort(array);
        assert array[0] == 1;
        assert array[1] == 2;
        assert array[2] == 3;
        assert array[3] == 4;
        assert array[4] == 5;
    }
}
