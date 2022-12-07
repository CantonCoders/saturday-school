package org.example.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneAwayTest {

    @Test
    public void equalWordsEvaluateTrue() {
        assertTrue(OneAway.evaluate("dream", "dream"));
    }

    @Test
    public void oneInsertAway() {
        assertTrue(OneAway.evaluate("drea", "dream"));
        assertTrue(OneAway.evaluate("dram", "dream"));
        assertTrue(OneAway.evaluate("ream", "dream"));
    }

    @Test
    public void twoInsertsAway() {
        assertFalse(OneAway.evaluate("dam", "dream"));
        assertFalse(OneAway.evaluate("eam", "dream"));
    }

    @Test
    public void oneRemoveAway() {
        assertTrue(OneAway.evaluate("drelam", "dream"));
        assertTrue(OneAway.evaluate("ldream", "dream"));
        assertTrue(OneAway.evaluate("dreaml", "dream"));
    }

    @Test
    public void twoRemovesAway() {
        assertFalse(OneAway.evaluate("drelamy", "dream"));
        assertFalse(OneAway.evaluate("ldreyam", "dream"));
    }

    @Test
    public void oneEditAway() {
        assertTrue(OneAway.evaluate("drenm", "dream"));
        assertTrue(OneAway.evaluate("drean", "dream"));
        assertTrue(OneAway.evaluate("tream", "dream"));
    }

    @Test
    public void twoEditsAway() {
        assertFalse(OneAway.evaluate("drnnm", "dream"));
    }

    @Test
    public void oneInsertAndOneEditAway() {
        assertFalse(OneAway.evaluate("drnm", "dream"));
    }

    @Test
    public void oneRemoveAndOneEditAway() {
        assertFalse(OneAway.evaluate("dreads", "dream"));
    }

    
    @Test
    public void returnsDifferenceOf2() {
        assertEquals(OneAway.findNumberOfDiff("drelamy", "dream"), 2);
        assertEquals(OneAway.findNumberOfDiff("ldreyam", "dream"), 2);
    }
    
    @Test
    public void returnsDifferenceOfMany() {
        assertEquals(OneAway.findNumberOfDiff("chfit", "dream"), 5);
    }

 }
