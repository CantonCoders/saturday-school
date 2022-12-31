package org.example.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

    @Test
    public void twoNodePalindrome() {
        var node = SinglyLinkedNode.buildLinkedList(1, 1);
        assertTrue(Palindrome.isPalindrome(node));
    }

    @Test
    public void twoNodeNonPalindrome() {
        var node = SinglyLinkedNode.buildLinkedList(1, 2);
        assertFalse(Palindrome.isPalindrome(node));
    }

    @Test
    public void threeNodePalindrome() {
        var node = SinglyLinkedNode.buildLinkedList(1, 2, 1);
        assertTrue(Palindrome.isPalindrome(node));
    }

    @Test
    public void threeNodeNonPalindrome() {
        var node = SinglyLinkedNode.buildLinkedList(1, 2, 2);
        assertFalse(Palindrome.isPalindrome(node));
    }

    @Test
    public void fourNodePalindrome() {
        var node = SinglyLinkedNode.buildLinkedList(1, 2, 3, 2, 1);
        assertTrue(Palindrome.isPalindrome(node));
    }

    @Test
    public void fourNodeNonPalindrome() {
        var node = SinglyLinkedNode.buildLinkedList(2, 1, 3, 2, 1);
        assertFalse(Palindrome.isPalindrome(node));
    }
}
