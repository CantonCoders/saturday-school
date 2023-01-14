package org.example.stackqueues;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class PlateStackTest {

    @Test
    public void initializeWithStackCapacity() {
        var stack = new PlateStack(5);
        var expected = new Object[] {
                new Object[] {null, null, null, null, null}
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    @Test
    public void fillingTheFirstStackDoesNotAddNewMemory() {
        var stack = new PlateStack(5);
        stackPushValues(stack, 1, 2, 3, 4, 5);

        var expected = new Object[] {
                new Object[] {1, 2, 3, 4, 5}
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    @Test
    public void exceedingCapacityCreatesNewStack() {
        var stack = new PlateStack(5);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8);

        var expected = new Object[] {
                new Object[] {1, 2, 3, 4, 5},
                new Object[] {6, 7, 8, null, null},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    @Test
    public void poppingPullsFromTopOfCurrentStack() {
        var stack = new PlateStack(5);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8);

        assertThat(stack.pop()).isEqualTo(8);
        assertThat(stack.pop()).isEqualTo(7);

        var expected = new Object[] {
                new Object[] {1, 2, 3, 4, 5},
                new Object[] {6, null, null, null, null},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    @Test
    public void poppingRollsBackToPreviousStack() {
        var stack = new PlateStack(5);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6);

        assertThat(stack.pop()).isEqualTo(6);
        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.pop()).isEqualTo(4);

        var expected = new Object[] {
                new Object[] {1, 2, 3, null, null},
                new Object[] {null, null, null, null, null},
        };

        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    @Test
    public void poppingNeverLeavesMoreThanOneEmptyStackAtTheEnd() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        var expected = new Object[] {
                new Object[] {1, 2, 3},
                new Object[] {4, 5, 6},
                new Object[] {7, 8, 9},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);

        for (var i = 9; i > 2; i--) {
            assertThat(stack.pop()).isEqualTo(i);
        }

        expected = new Object[] {
                new Object[] {1, 2, null},
                new Object[] {null, null, null},
        };

        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    @Test
    public void peekReturnsTheObjectFromTopOfStack() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(stack.peek()).isEqualTo(9);

        for (var i = 9; i > 2; i--) {
            assertThat(stack.pop()).isEqualTo(i);
        }

        assertThat(stack.peek()).isEqualTo(2);
    }

    @Test
    public void searchingReturnsTheIndexFromTopOfStack() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 10, 5, 10, 4, 5, 10, 8, 9);


        var expected = new Object[] {
                new Object[] {1, 10, 5},
                new Object[] {10, 4, 5},
                new Object[] {10, 8, 9},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);

        assertThat(stack.search(10)).isEqualTo(3);
        assertThat(stack.search(100)).isEqualTo(-1);
    }

    @Test
    public void searchingFindsFirstInstanceWithinAllStacks() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 10, 5, 10, 4, 5, 10, 8);

        var expected = new Object[] {
                new Object[] {1, 10, 5},
                new Object[] {10, 4, 5},
                new Object[] {10, 8, null},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);

        assertThat(stack.search(5)).isEqualTo(3);
        assertThat(stack.search(1)).isEqualTo(8);
        assertThat(stack.search(100)).isEqualTo(-1);
    }

    @Test
    public void searchingIgnoresLastEmptyStack() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 10, 5, 10, 4, 5, 6, 6, 6);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        var expected = new Object[] {
                new Object[] {1, 10, 5},
                new Object[] {10, 4, null},
                new Object[] {null, null, null},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);

        assertThat(stack.search(5)).isEqualTo(3);
        assertThat(stack.search(1)).isEqualTo(5);
        assertThat(stack.search(100)).isEqualTo(-1);
    }

    @Test
    public void popObjectFromIndexOnCurrentStack() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(stack.popAt(2)).isEqualTo(8);

        var expected = new Object[] {
                new Object[] {1, 2, 3},
                new Object[] {4, 5, 6},
                new Object[] {7, 9, null},
        };

        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    @Test
    public void popObjectFromIndexAnyStack() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(stack.popAt(6)).isEqualTo(4);

        var expected = new Object[] {
                new Object[] {1, 2, 3},
                new Object[] {5, 6, null},
                new Object[] {7, 8, 9},
        };

        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    @Test
    public void stackPositionAdjustsForStacksWithEmptySpace() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        stack.popAt(6);
        var expected = new Object[] {
                new Object[] {1, 2, 3},
                new Object[] {5, 6, null},
                new Object[] {7, 8, 9},
        };

        // search for element in the first stack
        assertThat(stack.search(2)).isEqualTo(7);

        // pop from the first stack
        assertThat(stack.popAt(7)).isEqualTo(2);
        expected = new Object[] {
                new Object[] {1, 3, null},
                new Object[] {5, 6, null},
                new Object[] {7, 8, 9},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);

        assertThat(stack.search(1)).isEqualTo(7);
    }

    @Test
    @Disabled
    // Work in progress - Feel free to complete it!
    public void removesEmptyStacksNotOnTheEnd() {
        var stack = new PlateStack(3);
        stackPushValues(stack, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        stack.popAt(stack.search(4));
        stack.popAt(stack.search(5));
        stack.popAt(stack.search(6));
        var expected = new Object[] {
                new Object[] {1, 2, 3},
                new Object[] {7, 8, 9},
                new Object[] {10, 11, 12},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);

        stack.popAt(stack.search(10));
        stack.popAt(stack.search(11));
        stack.popAt(stack.search(12));
        expected = new Object[] {
                new Object[] {1, 2, 3},
                new Object[] {7, 8, 9},
                new Object[] {null, null, null},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);

        assertThat(stack.search(7)).isEqualTo(3);
        stack.popAt(stack.search(7));
        stack.popAt(stack.search(8));
        stack.popAt(stack.search(9));
        expected = new Object[] {
                new Object[] {1, 2, 3},
                new Object[] {null, null, null},
        };
        assertThat(stack.getBackingArrays()).isEqualTo(expected);
    }

    private void stackPushValues(PlateStack stack, int ...values) {
        for (var value : values) {
            stack.push(value);
        }
    }
}
