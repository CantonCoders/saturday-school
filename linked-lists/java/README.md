# Instructions

Each exercise has an existing number of unit tests, some of which are passing and others are disabled. Your task is to implement the functionality using the test harness as a guide. Once all tests are passing for a given exercise, review the solution for improvements using these questions as a guide:

1. What will improved readability of the code?
2. What is the time complexity and can it be improved?
3. What is the space complexity and can it be improved?
4. What are the trad-offs between time and space complexity?

To begin an exercise, open the corresponding test class and run the tests. Implement the failing tests for each exercise.

**Source Material**
* _Cracking the Coding Interview: 189 Programming Questions and Solutions 6th Edition_ by Gayle Laakmann McDowell.


# Linked Lists

These exercises use both Singly and Doubly linked lists. You are allowed to create internal classes to each exercise, but only use the provided Linked List data structure. Avoid using Java provided data structures such as Lists, Arrays, Queues, etc.

## Remove Duplicates

`RemoveDuplicatesTest`

Implement the algorithm that removes duplicates from an unsorted linked list.

**Example:**
* List of `1 -> 1 -> 2 -> 3 -> 4 -> 5` would become `1 -> 2 -> 3 -> 4 -> 5`

**Challenge:** Do not use a temporary buffer.

## Find Nth To Last

`FindNthToLastTest`

Given the head of a linked list, find the Nth to the last element.

**Example:**
* The 2nd node of `1 -> 2 -> 4 -> 3 -> 7` would be `4`
* The 5th node of `1 -> 2 -> 4 -> 3 -> 7` would be `1`

## Remove the middle Node

`RemoveMiddleNodeTest`

Remove the middle node from a given linked list.

**Example:**
* For an odd Number of nodes: `3 -> 4 -> 5 -> 7 -> 1 -> 10 -> 99` remove the `7`
* For an even number of nodes: `3 -> 4 -> 5 -> 10` remove the `4`

## Partition the List

`PartitionTest`

Implement the algorithm to partition the linked list by the given value of `x`. Shift all values equal to greater than `x` to the right side of the list. *Important:* The partitions are not required to be in order. In the example below, the partition value is `5`, resulting `4` values in the left partition and `5` values in the right partition. 

**Example:**
* *INPUT:* `6, 1, 10, 3, 2, 8, 11, 4, 5`
* *PARTITION (x):* `5`
* *OUTPUT:* `1, 3, 2, 4, 6, 10, 8, 11, 5`

The tests validate values within the partitions. They do not enforce order of your results. A valid solution to the above example could be `4, 3, 1, 2, 8, 10, 11, 5` where the dived is between `2` and `8`. 

## Sum List Reversed

`SumListReversedTest`

This exercise creates two linked lists of single digit numbers. The lists are in reverse order where the ones position in the head node.

**Example:**
* A linked list A presenting 8,356 would be `6 -> 5 -> 3 -> 8`. 
* A linked list B presenting 76 would be `6 -> 7`.
* Add list A and B would create the linked list `3 -> 2 -> 4 -> 8` representing 8,423.

**The Hard Way:** Can you implement an algorithm that doesn't simply convert the lists to an Integer?

## Sum List In Order

`SumListInOrderTest`

This exercise is opposite the previous exercise, and is actually more challenging when the lists are unequal in length. It creates two linked lists of single digit numbers. The lists are in order where the ones position is at the tail node.

**Example:**
* A linked list A presenting 9,846 would be `9 -> 8 -> 4 -> 6`.
* A linked list B presenting 512 would be `5 -> 1 -> 2`.
* Add list A and B would create the linked list `1 -> 0 -> 3 -> 5 -> 8` representing 10,358.

**The Hard Way:** Can you implement an algorithm that doesn't simply convert the lists to an Integer?
