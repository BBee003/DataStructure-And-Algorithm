package com.dsalgo.solution.neetcode.datastructure;

import java.util.*;

public class Stack<T> {

    private final ArrayList<T> data;

    public Stack() {
        this.data = new ArrayList<>();
    }

    public T pop() {
        if (isEmpty()) return null;
        return data.removeLast();
    }

    public void push(T input) {
        data.add(input);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public T peek() {
        if (isEmpty()) return null;
        return data.getLast();
    }

    public int size() {
        return data.size();
    }
}
