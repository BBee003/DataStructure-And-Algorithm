package com.dsalgo.solution.neetcode.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinStackTest {

    private MinStack minStack;

    @BeforeEach
    void setUp() {
        minStack = new MinStack();
    }

    @Test
    void testPushAndGetMin() {
        minStack.push(5);
        assertEquals(5, minStack.getMin());
        
        minStack.push(3);
        assertEquals(3, minStack.getMin());
        
        minStack.push(7);
        assertEquals(3, minStack.getMin());
        
        minStack.push(2);
        assertEquals(2, minStack.getMin());
    }

    @Test
    void testPushTopAndPop() {
        minStack.push(10);
        minStack.push(20);
        minStack.push(30);
        
        assertEquals(30, minStack.top());
        assertEquals(30, minStack.pop());
        assertEquals(20, minStack.top());
        assertEquals(20, minStack.pop());
        assertEquals(10, minStack.top());
    }

    @Test
    void testGetMinAfterPop() {
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        
        assertEquals(3, minStack.getMin());
        
        minStack.pop();
        assertEquals(3, minStack.getMin());
        
        minStack.pop();
        assertEquals(5, minStack.getMin());
    }

    @Test
    void testSingleElement() {
        minStack.push(42);
        assertEquals(42, minStack.top());
        assertEquals(42, minStack.getMin());
        assertEquals(42, minStack.pop());
    }

    @Test
    void testPushSameValues() {
        minStack.push(5);
        minStack.push(5);
        minStack.push(5);
        
        assertEquals(5, minStack.top());
        assertEquals(5, minStack.getMin());
        
        minStack.pop();
        assertEquals(5, minStack.getMin());
        
        minStack.pop();
        assertEquals(5, minStack.getMin());
    }

    @Test
    void testDescendingOrder() {
        minStack.push(10);
        minStack.push(8);
        minStack.push(6);
        minStack.push(4);
        minStack.push(2);
        
        assertEquals(2, minStack.getMin());
        assertEquals(2, minStack.top());
        
        minStack.pop();
        assertEquals(4, minStack.getMin());
        
        minStack.pop();
        assertEquals(6, minStack.getMin());
        
        minStack.pop();
        assertEquals(8, minStack.getMin());
        
        minStack.pop();
        assertEquals(10, minStack.getMin());
    }

    @Test
    void testAscendingOrder() {
        minStack.push(1);
        minStack.push(3);
        minStack.push(5);
        minStack.push(7);
        minStack.push(9);
        
        assertEquals(1, minStack.getMin());
        assertEquals(9, minStack.top());
        
        minStack.pop();
        assertEquals(1, minStack.getMin());
        
        minStack.pop();
        assertEquals(1, minStack.getMin());
        
        minStack.pop();
        assertEquals(1, minStack.getMin());
        
        minStack.pop();
        assertEquals(1, minStack.getMin());
    }

    @Test
    void testMixedValues() {
        minStack.push(10);
        assertEquals(10, minStack.getMin());
        
        minStack.push(5);
        assertEquals(5, minStack.getMin());
        
        minStack.push(15);
        assertEquals(5, minStack.getMin());
        
        minStack.push(3);
        assertEquals(3, minStack.getMin());
        
        minStack.push(8);
        assertEquals(3, minStack.getMin());
        
        minStack.pop();
        assertEquals(3, minStack.getMin());
        
        minStack.pop();
        assertEquals(5, minStack.getMin());
    }

    @Test
    void testNegativeValues() {
        minStack.push(-5);
        assertEquals(-5, minStack.getMin());
        
        minStack.push(-10);
        assertEquals(-10, minStack.getMin());
        
        minStack.push(-3);
        assertEquals(-10, minStack.getMin());
        
        minStack.push(-15);
        assertEquals(-15, minStack.getMin());
        
        minStack.pop();
        assertEquals(-10, minStack.getMin());
    }

    @Test
    void testMixedPositiveAndNegative() {
        minStack.push(5);
        assertEquals(5, minStack.getMin());
        
        minStack.push(-2);
        assertEquals(-2, minStack.getMin());
        
        minStack.push(10);
        assertEquals(-2, minStack.getMin());
        
        minStack.push(-5);
        assertEquals(-5, minStack.getMin());
        
        minStack.push(0);
        assertEquals(-5, minStack.getMin());
    }

    @Test
    void testLargeNumbers() {
        minStack.push(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, minStack.getMin());
        
        minStack.push(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, minStack.getMin());
        
        minStack.push(0);
        assertEquals(Integer.MIN_VALUE, minStack.getMin());
    }

    @Test
    void testComplexScenario() {
        minStack.push(0);
        assertEquals(0, minStack.getMin());
        
        minStack.push(1);
        assertEquals(0, minStack.getMin());
        
        minStack.push(0);
        assertEquals(0, minStack.getMin());
        
        assertEquals(0, minStack.top());
        minStack.pop();
        assertEquals(0, minStack.getMin());
        
        assertEquals(1, minStack.top());
        minStack.pop();
        assertEquals(0, minStack.getMin());
        
        assertEquals(0, minStack.top());
        minStack.pop();
    }

    @Test
    void testNegativeScenario() {
        minStack.push(-2);
        minStack.push(-2);
        minStack.push(-3);
        minStack.push(-3);

        assertEquals(-3, minStack.getMin());
        assertEquals(-3, minStack.pop());
        assertEquals(-3, minStack.getMin());
    }

    @Test
    void testSpecificScenario() {
        // ["MinStack", "push", -1, "push", 5, "push", 0, "push", -5, "getMin", "pop", "getMin", "pop", "getMin", "pop", "getMin", "pop", "push", 4, "push", -4, "push", 2, "getMin", "pop", "getMin", "pop", "getMin"]
        
        // Initial pushes
        minStack.push(-1);
        minStack.push(5);
        minStack.push(0);
        minStack.push(-5);
        
        // First sequence of operations
        assertEquals(-5, minStack.getMin()); // getMin after pushing -5
        assertEquals(-5, minStack.pop());    // pop -5
        assertEquals(-1, minStack.getMin()); // getMin after popping -5
        assertEquals(0, minStack.pop());     // pop 0
        assertEquals(-1, minStack.getMin()); // getMin after popping 0
        assertEquals(5, minStack.pop());     // pop 5
        assertEquals(-1, minStack.getMin()); // getMin after popping 5
        assertEquals(-1, minStack.pop());    // pop -1
        
        // Second sequence of operations
        minStack.push(4);
        minStack.push(-4);
        minStack.push(2);
        
        assertEquals(-4, minStack.getMin()); // getMin after pushing 2
        assertEquals(2, minStack.pop());     // pop 2
        assertEquals(-4, minStack.getMin()); // getMin after popping 2
        assertEquals(-4, minStack.pop());    // pop -4
        assertEquals(4, minStack.getMin()); // getMin after popping -4
    }
}
