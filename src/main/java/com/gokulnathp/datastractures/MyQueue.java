package com.gokulnathp.datastractures;

public class MyQueue {
    private final StackArrayList<Integer> stack1 = new StackArrayList<>();
    private final StackArrayList<Integer> stack2 = new StackArrayList<>();

    public void enqueue(int value) {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());

        stack1.push(value);

        while (!stack2.isEmpty()) stack1.push(stack2.pop());
    }

    public Integer dequeue() {
        return stack1.pop();
    }
}
