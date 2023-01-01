package org.example.stackqueues;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThreeInOneFixedStackTest {

    @Test
    public void allocatesMemoryForTheStacks() {
        var stacks = new ThreeInOneFixedStack(90);
        assertThat(stacks.getBackingArray().length).isEqualTo(90);
    }

    @Test
    public void allocationMustBeDivisibleByThree() {
        Exception ex = assertThrows(InvalidAllocationException.class, () -> new ThreeInOneFixedStack(91));
        assertThat(ex.getMessage()).isEqualTo("Allocation size must be divisible by 3.");
    }

    @Test
    public void stackInitializesValuesToNull() {
        var stacks = new ThreeInOneFixedStack(9);
        var expected = new Object[]{
                null, null, null,
                null, null, null,
                null, null, null
        };
        assertThat(stacks.getBackingArray()).isEqualTo(expected);
    }

    @Test
    public void canAddDataToEachStack() {
        var stacks = new ThreeInOneFixedStack(9);
        pushToFirstStack(stacks, 1001);
        pushToSecondStack(stacks, 1002);
        pushToThirdStack(stacks, 1003);

        var expected = new Object[]{
                1001, null, null,
                1002, null, null,
                1003, null, null
        };
        assertThat(stacks.getBackingArray()).isEqualTo(expected);
    }

    @Test
    public void canPopDataFromEachStack() {
        var stacks = new ThreeInOneFixedStack(9);
        pushToFirstStack(stacks, 1011, 1012, 1013);
        pushToSecondStack(stacks, 2011, 2012);
        pushToThirdStack(stacks, 2013);

        assertThat(stacks.pop(StackNumber.ONE)).isEqualTo(1013);
        assertThat(stacks.pop(StackNumber.TWO)).isEqualTo(2012);
        assertThat(stacks.pop(StackNumber.THREE)).isEqualTo(2013);

        var backingArray = stacks.getBackingArray();
        var expected = new Object[]{
                1011, 1012, null,
                2011, null, null,
                null, null, null
        };
        assertThat(backingArray).isEqualTo(expected);
    }

    @Test
    public void canFillEachStack() {
        var stacks = new ThreeInOneFixedStack(9);
        pushToFirstStack(stacks, 1011, 1012, 1013);
        pushToSecondStack(stacks, 2021, 2022, 2023);
        pushToThirdStack(stacks, 3031, 3032, 3033);

        var backingArray = stacks.getBackingArray();
        var expected = new Object[]{
                1011, 1012, 1013,
                2021, 2022, 2023,
                3031, 3032, 3033
        };
        assertThat(backingArray).isEqualTo(expected);
    }

    @Test
    public void throwsExceptionWhenStackIsFull() {
        var stacks = new ThreeInOneFixedStack(9);
        pushToFirstStack(stacks, 1011, 1012, 1013);
        pushToSecondStack(stacks, 2021, 2022, 2023);
        pushToThirdStack(stacks, 3031, 3032, 3033);

        assertThrows(StackFullException.class, () -> stacks.push(StackNumber.ONE, 1014));
        assertThrows(StackFullException.class, () -> stacks.push(StackNumber.TWO, 2014));
        assertThrows(StackFullException.class, () -> stacks.push(StackNumber.THREE, 3014));
    }

    @Test
    public void throwsExceptionWhenStackIsEmpty() {
        var stacks = new ThreeInOneFixedStack(3);

        assertThrows(EmptyStackException.class, () -> stacks.pop(StackNumber.ONE));
        assertThrows(EmptyStackException.class, () -> stacks.pop(StackNumber.TWO));
        assertThrows(EmptyStackException.class, () -> stacks.pop(StackNumber.THREE));
    }

    @Test
    public void canPeekAtEachStackWithoutRemovingData() {
        var stacks = new ThreeInOneFixedStack(9);
        pushToFirstStack(stacks, 1011, 1012);
        pushToSecondStack(stacks, 2021, 2022);
        pushToThirdStack(stacks, 3031, 3032);

        assertThat(stacks.peek(StackNumber.ONE)).isEqualTo(1012);

        var backingArray = stacks.getBackingArray();
        var expected = new Object[]{
                1011, 1012, null,
                2021, 2022, null,
                3031, 3032, null
        };
        assertThat(backingArray).isEqualTo(expected);
    }

    @Test
    public void peekAtEmptyListThrowException() {
        var stacks = new ThreeInOneFixedStack(9);

        assertThrows(EmptyStackException.class, () -> stacks.peek(StackNumber.ONE));
        assertThrows(EmptyStackException.class, () -> stacks.peek(StackNumber.TWO));
        assertThrows(EmptyStackException.class, () -> stacks.peek(StackNumber.THREE));
    }

    private static void pushToFirstStack(ThreeInOneFixedStack stack, Object ...objects) {
        for (var object: objects) {
            stack.push(StackNumber.ONE, object);
        }
    }

    private static void pushToSecondStack(ThreeInOneFixedStack stack, Object ...objects) {
        for (var object: objects) {
            stack.push(StackNumber.TWO, object);
        }
    }

    private static void pushToThirdStack(ThreeInOneFixedStack stack, Object ...objects) {
        for (var object: objects) {
            stack.push(StackNumber.THREE, object);
        }
    }

}
