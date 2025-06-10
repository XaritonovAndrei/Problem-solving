package com.problem_solving.Design_Max_Stack;

//Design a max stack that supports push, pop, top, peekMax and popMax.

//push(x) -- Push element x onto stack.
//pop() -- Remove the element on top of the stack and return it.
//top() -- Get the element on the top.
//peekMax() -- Retrieve the maximum element in the stack.
//popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

import java.util.Stack;

public class DesignMaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public DesignMaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : Math.max(maxStack.peek(), x);
        stack.push(x);
        maxStack.push(max);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (top() != max) {
            buffer.push(pop());
        }
        pop(); // Removing maximum value element
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }
}
