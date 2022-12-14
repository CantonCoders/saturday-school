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

**Example:**
* Input:  `"Canton Coders  "`
* Output: `"Canton%20Coders"`

**Extra Credit:**
* Add logic that handles leading and trailing spaces. 

## Palindrome Permutation

Implement the method that checks if a string is a palindrome permutation. The palindrome is not limited to dictionary words. It will ignore case and non-letter characters. A palindrome is a word or phrase that is the same both forward and backwards. A palindrome permutation is the rearrangement of those characters that can be the same both forward and backwords. 

**Example:**
* String 1: `"Race car"`
* String 2: `"Car race"`

String 2 is a Palindrome Permutation as it is a permutation of String 1, which is a palindrome.  

## One Away

Given two strings, there are three types of edits performed to make the two strings equal: Insert a character, remove a character, or replace a character. Implement a method that determines if one or fewer edits is necessary to make the two given strings equal.

**Examples:**
* `dream`, `dream` -> `True` (No edits needed)
* `deam`, `dream` -> `True` (One Insert needed)
* `dea`, `dream` -> `False` (Two Inserts needed)
* `dreamy`, `dream` -> `True` (One Remove needed)
* `drean`, `drean` -> `True` (One Replace needed)

## Compression

Implement the method to use basic string compression using counts of repeating characters. The method will return the compressed string if it's shorter than the original string, otherwise it returns the original string. Assume the string contains only upper and lowercase letters. 

**Examples**
* `"aa"` returns `"aa"`
* `"aaa"` returns `"a3"`
* `"aaabb"` returns `"a3b2"`
* `"aabb"` returns `"aabb"` (The compressed string is equal length to the original.)