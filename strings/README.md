# Instructions

Each exercise has an existing number of unit tests, some of which are passing and others are disabled. Your task is to implement the functionality using the test harness as a guide. Once all tests are passing for a given exercise, review the solution for improvements using these questions as a guide:

1. What will improved readability of the code?
2. What is the time complexity and can it be improved?
3. What is the space complexity and can it be improved? 
4. What are the trade offs between time and space complexity? 

To begin an exercise, open the corresponding test class and run the tests. Remove a `@Disabled` tag and implement the rule for that test. The `@Disabled` tags may be removed incrementally or all at once.

**Source Material**
* _Cracking the Coding Interview: 189 Programming Questions and Solutions 6th Edition_ by Gayle Laakmann McDowell.


# Strings 

For the String exercises, the character sets are assumed to be [ASCII](https://www.ascii-code.com/) code. 

## Unique

Given a string, implement the method to determine if the string contains all unique characters. This method will be case sensitive. For example, "Aa" is unique but "AA" is not unique. 

**Extra Credit:**
* Create a second method that ignores character case and spaces.
* Implement the algorithm without the help of String utility classes.
* Implement without using additional data structures. 

## Permutation

Given two strings, write a method that checks if one is a permutation of another.

**Extra Credit:**
* Create a second check permutation method that ignores case. (Do not use a flag parameter to change the behavior of the existing method.)

## URLify

Implement the method to replace all spaces in a String with `'%20'`. This must be done using an in-place algorithm. The string value will not contain leading or trailing spaces. Assume the string is ASCII and has sufficient space to hold the additional characters needed.

Since Java String is immutable, this implementation will use a `char` array for implementing an in-place algorithm.

**Extra Credit:**
* Add logic that handles leading and trailing spaces. 

**Examples**
* Input:  `"Canton Coders  "`
* Output: `"Canton%20Coders"`

## Palindrome Permutation