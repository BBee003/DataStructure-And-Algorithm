package com.dsalgo.solution.neetcode.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesesTest {

    private ValidParentheses validParentheses;

    @BeforeEach
    void setUp() {
        validParentheses = new ValidParentheses();
    }

    @Test
    void testValidSimpleParentheses() {
        assertTrue(validParentheses._v1Solve("()"));
    }

    @Test
    void testValidSimpleBrackets() {
        assertTrue(validParentheses._v1Solve("[]"));
    }

    @Test
    void testValidSimpleBraces() {
        assertTrue(validParentheses._v1Solve("{}"));
    }

    @Test
    void testValidMixedParentheses() {
        assertTrue(validParentheses._v1Solve("()[]{}"));
    }

    @Test
    void testValidNestedParentheses() {
        assertTrue(validParentheses._v1Solve("({[]})"));
    }

    @Test
    void testValidComplexNested() {
        assertTrue(validParentheses._v1Solve("{[()]}"));
    }

    @Test
    void testValidDeeplyNested() {
        assertTrue(validParentheses._v1Solve("((({{{[[[]]]}}})))"));
    }

    @Test
    void testInvalidMismatchedParentheses() {
        assertFalse(validParentheses._v1Solve("(]"));
    }

    @Test
    void testInvalidMismatchedBrackets() {
        assertFalse(validParentheses._v1Solve("([)]"));
    }

    @Test
    void testInvalidExtraClosingParentheses() {
        assertFalse(validParentheses._v1Solve("())"));
    }

    @Test
    void testInvalidExtraOpeningParentheses() {
        assertFalse(validParentheses._v1Solve("(()"));
    }

    @Test
    void testInvalidOnlyClosingBrackets() {
        assertFalse(validParentheses._v1Solve("]"));
    }

    @Test
    void testInvalidOnlyOpeningBrackets() {
        assertFalse(validParentheses._v1Solve("["));
    }

    @Test
    void testInvalidEmptyString() {
        assertFalse(validParentheses._v1Solve(""));
    }

    @Test
    void testInvalidSingleCharacter() {
        assertFalse(validParentheses._v1Solve("a"));
    }

    @Test
    void testInvalidMixedCharacters() {
        assertFalse(validParentheses._v1Solve("(a)"));
    }

    @Test
    void testInvalidPartialMatch() {
        assertFalse(validParentheses._v1Solve("({)}"));
    }

    @Test
    void testInvalidWrongOrder() {
        assertFalse(validParentheses._v1Solve("]["));
    }

    @Test
    void testValidLongString() {
        String longValid = "((({{{[[[]]]}}})))".repeat(10);
        assertTrue(validParentheses._v1Solve(longValid));
    }

    @Test
    void testInvalidLongString() {
        String longInvalid = "((({{{[[[]]]}}})))(".repeat(10);
        assertFalse(validParentheses._v1Solve(longInvalid));
    }

    // V2 Test Cases
    @Test
    void testValidSimpleParentheses_v2() {
        assertTrue(validParentheses._v2Solve("()"));
    }

    @Test
    void testValidSimpleBrackets_v2() {
        assertTrue(validParentheses._v2Solve("[]"));
    }

    @Test
    void testValidSimpleBraces_v2() {
        assertTrue(validParentheses._v2Solve("{}"));
    }

    @Test
    void testValidMixedParentheses_v2() {
        assertTrue(validParentheses._v2Solve("()[]{}"));
    }

    @Test
    void testValidNestedParentheses_v2() {
        assertTrue(validParentheses._v2Solve("({[]})"));
    }

    @Test
    void testValidComplexNested_v2() {
        assertTrue(validParentheses._v2Solve("{[()]}"));
    }

    @Test
    void testValidDeeplyNested_v2() {
        assertTrue(validParentheses._v2Solve("((({{{[[[]]]}}})))"));
    }

    @Test
    void testInvalidMismatchedParentheses_v2() {
        assertFalse(validParentheses._v2Solve("(]"));
    }

    @Test
    void testInvalidMismatchedBrackets_v2() {
        assertFalse(validParentheses._v2Solve("([)]"));
    }

    @Test
    void testInvalidExtraClosingParentheses_v2() {
        assertFalse(validParentheses._v2Solve("())"));
    }

    @Test
    void testInvalidExtraOpeningParentheses_v2() {
        assertFalse(validParentheses._v2Solve("(()"));
    }

    @Test
    void testInvalidOnlyClosingBrackets_v2() {
        assertFalse(validParentheses._v2Solve("]"));
    }

    @Test
    void testInvalidOnlyOpeningBrackets_v2() {
        assertFalse(validParentheses._v2Solve("["));
    }

    @Test
    void testInvalidEmptyString_v2() {
        assertFalse(validParentheses._v2Solve(""));
    }

    @Test
    void testInvalidSingleCharacter_v2() {
        assertFalse(validParentheses._v2Solve("a"));
    }

    @Test
    void testInvalidMixedCharacters_v2() {
        assertFalse(validParentheses._v2Solve("(a)"));
    }

    @Test
    void testInvalidPartialMatch_v2() {
        assertFalse(validParentheses._v2Solve("({)}"));
    }

    @Test
    void testInvalidWrongOrder_v2() {
        assertFalse(validParentheses._v2Solve("]["));
    }

    @Test
    void testValidLongString_v2() {
        String longValid = "((({{{[[[]]]}}})))".repeat(10);
        assertTrue(validParentheses._v2Solve(longValid));
    }

    @Test
    void testInvalidLongString_v2() {
        String longInvalid = "((({{{[[[]]]}}})))(".repeat(10);
        assertFalse(validParentheses._v2Solve(longInvalid));
    }
}