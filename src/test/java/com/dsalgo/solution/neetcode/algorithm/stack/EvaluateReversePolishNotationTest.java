package com.dsalgo.solution.neetcode.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateReversePolishNotationTest {
    
    private EvaluateReversePolishNotation evaluator;
    
    @BeforeEach
    void setUp() {
        evaluator = new EvaluateReversePolishNotation();
    }
    
    @Test
    @DisplayName("Test basic addition")
    void testBasicAddition() {
        String[] tokens = {"2", "1", "+"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(3, result);
    }
    
    @Test
    @DisplayName("Test basic subtraction")
    void testBasicSubtraction() {
        String[] tokens = {"4", "13", "-"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(-9, result);
    }
    
    @Test
    @DisplayName("Test basic multiplication")
    void testBasicMultiplication() {
        String[] tokens = {"3", "4", "*"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(12, result);
    }
    
    @Test
    @DisplayName("Test basic division")
    void testBasicDivision() {
        String[] tokens = {"10", "2", "/"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(5, result);
    }
    
    @Test
    @DisplayName("Test complex expression with multiple operations")
    void testComplexExpression() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(9, result);
    }
    
    @Test
    @DisplayName("Test complex expression with all operations")
    void testComplexExpressionAllOperations() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(6, result);
    }
    
    @Test
    @DisplayName("Test expression with negative numbers")
    void testNegativeNumbers() {
        String[] tokens = {"-2", "3", "+"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(1, result);
    }
    
    @Test
    @DisplayName("Test expression resulting in negative number")
    void testNegativeResult() {
        String[] tokens = {"2", "5", "-"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(-3, result);
    }
    
    @Test
    @DisplayName("Test single number")
    void testSingleNumber() {
        String[] tokens = {"42"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(42, result);
    }
    
    @Test
    @DisplayName("Test multiple operations in sequence")
    void testMultipleOperations() {
        String[] tokens = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(14, result);
    }
    
    @Test
    @DisplayName("Test division with truncation toward zero")
    void testDivisionTruncation() {
        String[] tokens = {"7", "3", "/"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(2, result);
    }
    
    @Test
    @DisplayName("Test negative division")
    void testNegativeDivision() {
        String[] tokens = {"-7", "3", "/"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(-2, result);
    }
    
    @Test
    @DisplayName("Test division by negative number")
    void testDivisionByNegative() {
        String[] tokens = {"7", "-3", "/"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(-2, result);
    }
    
    @Test
    @DisplayName("Test zero in expression")
    void testZeroInExpression() {
        String[] tokens = {"0", "5", "+"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(5, result);
    }
    
    @Test
    @DisplayName("Test multiplication by zero")
    void testMultiplicationByZero() {
        String[] tokens = {"5", "0", "*"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Test empty array throws exception")
    void testEmptyArray() {
        String[] tokens = {};
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> evaluator._v1Solve(tokens)
        );
        assertEquals("Input token is empty", exception.getMessage());
    }
    
    @Test
    @DisplayName("Test invalid number format")
    void testInvalidNumberFormat() {
        String[] tokens = {"abc", "2", "+"};
        assertThrows(NumberFormatException.class, () -> evaluator._v1Solve(tokens));
    }
    
    @Test
    @DisplayName("Test large numbers")
    void testLargeNumbers() {
        String[] tokens = {"1000000", "2000000", "+"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(3000000, result);
    }
    
    @Test
    @DisplayName("Test integer overflow scenario")
    void testIntegerOverflow() {
        String[] tokens = {"2147483647", "1", "+"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(-2147483648, result);
    }
    
    @Test
    @DisplayName("Test complex nested operations")
    void testComplexNestedOperations() {
        String[] tokens = {"15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(5, result);
    }
    
    @Test
    @DisplayName("Test all four operations in one expression")
    void testAllOperations() {
        String[] tokens = {"10", "2", "/", "3", "*", "4", "+", "5", "-"};
        int result = evaluator._v1Solve(tokens);
        assertEquals(14, result);
    }
}
