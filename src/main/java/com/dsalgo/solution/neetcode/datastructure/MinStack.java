package com.dsalgo.solution.neetcode.datastructure;

public class MinStack {

    private final Stack<Integer> data;
    private final Stack<Integer> minData;

    public MinStack() {
        this.data = new Stack<>();
        this.minData = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        int minVal = minData.isEmpty() ? val : Math.min(val, minData.peek());
        minData.push(minVal);
    }

    public int pop() {
        if (data.isEmpty()) throw new IllegalStateException();
        minData.pop();
        return data.pop();
    }

    public int top() {
        if (data.isEmpty()) throw new IllegalStateException();
        return data.peek();
    }

    public int getMin() {
        if (minData.isEmpty()) throw new IllegalStateException();
        return minData.peek();
    }
}