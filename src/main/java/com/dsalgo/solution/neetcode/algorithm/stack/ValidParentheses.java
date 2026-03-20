package com.dsalgo.solution.neetcode.algorithm.stack;

import com.dsalgo.solution.neetcode.datastructure.Stack;

public class ValidParentheses {

    /**
     * Steps:
     *      1. check each brackets of input string
     *      2. if open bracket detect, push to stack
     *      3. if close bracket detect, get and compare with the close bracket from stack
     *      4. if comparison fail, input string is invalid
     * Complexity:
     *      1. time: O(n)
     *      2. space: O(n)
     */
    public boolean _v1Solve(String input) {
        if (input.isEmpty()) return false;

        Stack<Character> openBrackets = new Stack<>();
        for (char bracket: input.toCharArray()) {
            if (_v1IsOpenBracket(bracket)) {
                openBrackets.push(bracket);
            } else {
                Character openBracket = openBrackets.pop();
                if (openBracket == null || bracket != _v1GetCloseBracket(openBracket)) return false;
            }
        }

        return openBrackets.isEmpty();
    }

    private char _v1GetCloseBracket(char bracket) {
        if (_v1IsOpenBracket(bracket)) return bracket == '(' ? ')' : bracket == '[' ? ']' : '}';
        return bracket;
    }

    private boolean _v1IsOpenBracket(char bracket) {
        return bracket == '(' || bracket == '[' || bracket == '{';
    }

    /**
     * STEPS:
     *      1. Iterate through each character in the input string.
     *      2. If the character is an opening bracket, push it onto the stack.
     *      3. If the character is a closing bracket:
     *          a. Pop the top of the stack (if stack is empty → invalid).
     *          b. Check if the popped opening bracket matches the closing bracket.
     *          c. If not, return false immediately.
     *      4. After processing all characters, return true if the stack is empty (all brackets matched), false otherwise.
     * -
     * COMPLEXITY:
     *      1. Time: O(n) each character is processed once.
     *      2. Space: O(n) stack could hold up to n brackets.
     */
    public boolean _v2Solve(String input) {
        if (input.isEmpty()) return false;

        Stack<Character> openBrackets = new Stack<>();
        for (char bracket : input.toCharArray()) {
            if (_v1IsOpenBracket(bracket)) {
                openBrackets.push(bracket);
            } else {
                if (openBrackets.isEmpty()) return false;
                char openBracket = openBrackets.pop();
                if (bracket != _v2GetCloseBracket(openBracket)) return false;
            }
        }

        return openBrackets.isEmpty();
    }

    private char _v2GetCloseBracket(char bracket) {
        return switch(bracket) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            default -> throw new IllegalArgumentException("Invalid Bracket");
        };
    }
}