# Instructions

Each exercise has an existing number of unit tests, some of which are passing and others are disabled. Your task is to implement the functionality using the test harness as a guide. Once all tests are passing for a given exercise, review the solution for improvements using these questions as a guide:

1. What will improved readability of the code?
2. What is the time complexity and can it be improved?
3. What is the space complexity and can it be improved?
4. What are the trad-offs between time and space complexity?

To begin an exercise, open the corresponding test class and run the tests. Implement the failing tests for each exercise.

**Source Material**
* _Cracking the Coding Interview: 189 Programming Questions and Solutions 6th Edition_ by Gayle Laakmann McDowell.


# Stacks and Queues

## Fixed Stack

`FixedStackTest`

This exercise implements a stack backed by an array. The stack size is limited by the capacity of the backing array.

## Flexible Stack

`FlexibleStackTest`

The Flexible Stack is also backed by an array. This exercise expects the Flexible Stack to double capacity whenever the stack becomes filled.

_Note:_ Before starting on the Flexible Stack, consider the api between the two implementations. Is there opportunity for code reuse through a Shared API or Abstraction? 

## Three In One Fixed Stack

`ThreeInOneFixedStackTest`

Implement the data structure that provides three stacks backed by the single array. The backing array will be divided into three equal parts and each stack will be assigned a segment of that array.

*Example:*
Given a capacity of `n`, each stack will have a capacity of `n / 3` objects. The stacks will only use their assigned segment of the array: 
* Stack 1 `[0, n / 3]`
* Stack 2 `[n / 3, 2n / 3]`
* Stack 3 `[2n / 3, n]`


