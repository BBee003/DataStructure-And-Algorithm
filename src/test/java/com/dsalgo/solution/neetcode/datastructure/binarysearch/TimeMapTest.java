package com.dsalgo.solution.neetcode.datastructure.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TimeMapTest {

    private TimeMap timeMap;

    @BeforeEach
    void setUp() {
        timeMap = new TimeMap();
    }

    @Test
    @DisplayName("Test basic set and get operations")
    void testBasicSetAndGet() {
        timeMap.set("apple", "red", 1);
        assertEquals("red", timeMap.get("apple", 1));
        assertEquals("red", timeMap.get("apple", 10));
    }

    @Test
    @DisplayName("Test get on non-existent key")
    void testGetNonExistentKey() {
        assertEquals("", timeMap.get("nonexistent", 1));
        assertEquals("", timeMap.get("nonexistent", 100));
    }

    @Test
    @DisplayName("Test multiple values for same key")
    void testMultipleValuesSameKey() {
        timeMap.set("fruit", "apple", 1);
        timeMap.set("fruit", "banana", 2);
        timeMap.set("fruit", "cherry", 3);

        assertEquals("apple", timeMap.get("fruit", 1));
        assertEquals("banana", timeMap.get("fruit", 2));
        assertEquals("cherry", timeMap.get("fruit", 3));
        assertEquals("cherry", timeMap.get("fruit", 4));
        assertEquals("banana", timeMap.get("fruit", 2));
        assertEquals("apple", timeMap.get("fruit", 1));
    }

    @Test
    @DisplayName("Test get with exact timestamp match")
    void testGetExactTimestampMatch() {
        timeMap.set("test", "val1", 3);
        timeMap.set("test", "val2", 7);
        timeMap.set("test", "val3", 12);

        assertEquals("val1", timeMap.get("test", 3));
        assertEquals("val2", timeMap.get("test", 7));
        assertEquals("val3", timeMap.get("test", 12));
    }

    @Test
    @DisplayName("Test get with timestamp between entries")
    void testGetBetweenEntries() {
        timeMap.set("data", "first", 1);
        timeMap.set("data", "second", 5);
        timeMap.set("data", "third", 10);

        assertEquals("first", timeMap.get("data", 2));
        assertEquals("first", timeMap.get("data", 4));
        assertEquals("second", timeMap.get("data", 6));
        assertEquals("second", timeMap.get("data", 9));
        assertEquals("third", timeMap.get("data", 15));
    }

    @Test
    @DisplayName("Test multiple keys")
    void testMultipleKeys() {
        timeMap.set("key1", "val1", 1);
        timeMap.set("key2", "val2", 2);
        timeMap.set("key1", "val3", 3);
        timeMap.set("key2", "val4", 4);

        assertEquals("val1", timeMap.get("key1", 1));
        assertEquals("val3", timeMap.get("key1", 3));
        assertEquals("val2", timeMap.get("key2", 2));
        assertEquals("val4", timeMap.get("key2", 4));
        assertEquals("val3", timeMap.get("key1", 5));
        assertEquals("val4", timeMap.get("key2", 5));
    }

    @Test
    @DisplayName("Test with large timestamps")
    void testLargeTimestamps() {
        timeMap.set("large", "small", 1000000);
        timeMap.set("large", "medium", 5000000);
        timeMap.set("large", "big", 10000000);

        assertEquals("small", timeMap.get("large", 1000000));
        assertEquals("medium", timeMap.get("large", 5000000));
        assertEquals("big", timeMap.get("large", 10000000));
        assertEquals("big", timeMap.get("large", 20000000));
        assertEquals("medium", timeMap.get("large", 7500000));
        assertEquals("small", timeMap.get("large", 2500000));
    }

    @Test
    @DisplayName("Test with negative timestamps")
    void testNegativeTimestamps() {
        timeMap.set("neg", "val1", -5);
        timeMap.set("neg", "val2", -1);
        timeMap.set("neg", "val3", 3);

        assertEquals("val1", timeMap.get("neg", -5));
        assertEquals("val2", timeMap.get("neg", -1));
        assertEquals("val3", timeMap.get("neg", 3));
        assertEquals("val1", timeMap.get("neg", -3));
        assertEquals("val2", timeMap.get("neg", 0));
        assertEquals("val3", timeMap.get("neg", 5));
    }

    @Test
    @DisplayName("Test binary search with many entries")
    void testBinarySearchWithManyEntries() {
        // Add 100 entries with timestamps 1-100
        for (int i = 1; i <= 100; i++) {
            timeMap.set("many", "value" + i, i);
        }

        // Test various timestamps
        assertEquals("value1", timeMap.get("many", 1));
        assertEquals("value50", timeMap.get("many", 50));
        assertEquals("value100", timeMap.get("many", 100));
        assertEquals("value75", timeMap.get("many", 75));
        assertEquals("value25", timeMap.get("many", 25));
        assertEquals("value100", timeMap.get("many", 150));
        assertEquals("value99", timeMap.get("many", 99));
        assertEquals("value1", timeMap.get("many", 1));
    }

    @Test
    @DisplayName("Test with empty strings as values")
    void testEmptyStringValues() {
        timeMap.set("empty", "", 1);
        timeMap.set("empty", "not empty", 2);
        timeMap.set("empty", "", 3);

        assertEquals("", timeMap.get("empty", 1));
        assertEquals("not empty", timeMap.get("empty", 2));
        assertEquals("", timeMap.get("empty", 3));
        assertEquals("", timeMap.get("empty", 4));
        assertEquals("not empty", timeMap.get("empty", 2));
    }

    @Test
    @DisplayName("Test with special characters in keys and values")
    void testSpecialCharacters() {
        timeMap.set("key!@#$%", "value*&^%", 1);
        timeMap.set("key with spaces", "value with spaces", 2);
        timeMap.set("key\nwith\tnewlines", "value\nwith\ttabs", 3);

        assertEquals("value*&^%", timeMap.get("key!@#$%", 1));
        assertEquals("value with spaces", timeMap.get("key with spaces", 2));
        assertEquals("value\nwith\ttabs", timeMap.get("key\nwith\tnewlines", 3));
    }

    @Test
    @DisplayName("Test same timestamp for same key (edge case)")
    void testSameTimestampSameKey() {
        timeMap.set("same", "first", 5);
        timeMap.set("same", "second", 5); // Same timestamp
        timeMap.set("same", "third", 6);

        // The behavior depends on implementation, but should be consistent
        String result = timeMap.get("same", 5);
        assertTrue(result.equals("first") || result.equals("second"));
        assertEquals("third", timeMap.get("same", 6));
    }

    @Test
    @DisplayName("Test get after many set operations")
    void testGetAfterManySetOperations() {
        // Perform many set operations
        for (int i = 0; i < 50; i++) {
            timeMap.set("persistent", "iteration" + i, i * 2);
        }

        // Test that all values are still accessible
        assertEquals("iteration0", timeMap.get("persistent", 0));
        assertEquals("iteration10", timeMap.get("persistent", 20));
        assertEquals("iteration25", timeMap.get("persistent", 50));
        assertEquals("iteration49", timeMap.get("persistent", 98));
        assertEquals("iteration49", timeMap.get("persistent", 200));
    }

    @Test
    @DisplayName("Test constructor initialization")
    void testConstructorInitialization() {
        TimeMap newTimeMap = new TimeMap();
        assertNotNull(newTimeMap);
        assertEquals("", newTimeMap.get("anykey", 1));
    }

    @Test
    @DisplayName("Test complex scenario from LeetCode example")
    void testComplexScenario() {
        // Simulate a complex usage scenario
        timeMap.set("foo", "bar", 1);
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 3));
        
        timeMap.set("foo", "bar2", 4);
        assertEquals("bar2", timeMap.get("foo", 4));
        assertEquals("bar2", timeMap.get("foo", 5));
        
        timeMap.set("baz", "bang", 2);
        assertEquals("bang", timeMap.get("baz", 2));
        assertEquals("bang", timeMap.get("baz", 3));
        assertEquals("bang", timeMap.get("baz", 100));
        
        // Test that foo still works
        assertEquals("bar", timeMap.get("foo", 2));
        assertEquals("bar2", timeMap.get("foo", 10));
    }

    @Test
    @DisplayName("Test complex scenario from LeetCode example")
    void testNeetCodeFail() {
        // Simulate a complex usage scenario
        timeMap.set("key1", "value1", 10);
        assertEquals("", timeMap.get("key1", 1));
        assertEquals("value1", timeMap.get("key1", 10));
        assertEquals("value1", timeMap.get("key1", 11));
    }
}
