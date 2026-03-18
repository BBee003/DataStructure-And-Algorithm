package com.dsalgo.solution.neetcode.algorithm.stack;

import com.dsalgo.solution.neetcode.datastructure.Stack;

public class EvaluateReversePolishNotation {
    
    /*
     *
     * STEPS:
     *      1. Iterate through every items from the input token.
     *      2. If item is operand, add to the stack.
     *      3. If item is operator, 
     *          1. Pop two operands from stack 
     *          2. Operate these operands with current operator
     *          3. Put the result back to the stack
     *      4. Return the last value from the stack
     * 
     * COMPLEXITY:
     *      1. Time: O(n) process all the elements from input array
     *      2. Space: O(n) store all the operands into stack
     */
    public int _v1Solve(String[] tokens) {
        if (tokens.length == 0) throw new IllegalArgumentException("Input token is empty");

        Stack<Integer> operands = new Stack<>();
        for (String token: tokens) {
            if (isOperator(token)) {
                if (operands.size() < 2) throw new IllegalArgumentException("Invalid arithmetic expression");
                int secondOperand = operands.pop();
                int firstOperand = operands.pop();
                int result = operate(firstOperand, secondOperand, token);
                operands.push(result);
            } else {
                operands.push(Integer.parseInt(token));
            }
        }

        return operands.pop();
    }

    private int operate(int firstOperand, int secondOperand, String operator) {
        return switch(operator) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "/" -> firstOperand / secondOperand;
            case "%" -> firstOperand % secondOperand;
            default -> throw new IllegalArgumentException("Invalid input operator");
        };
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }
}
