package com.spring.springpractice;


import java.util.*;
class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> mainStack;

    Map<Integer, Integer> counterMap = new HashMap<>();

    public MinStack() {
        minStack = new Stack<>();
        mainStack = new Stack<>();
    }

    public void push(int val) {

        if(minStack.isEmpty()){
            minStack.push(val);
        } else if (val < minStack.peek()){
            minStack.push(val);
        }

        Integer count = counterMap.getOrDefault(val, 0) + 1;
        counterMap.put(val, count);

        mainStack.push(val);
    }

    public void pop() {
        Integer removedElement = mainStack.pop();
        if(removedElement.equals(minStack.peek()) && (counterMap.get(removedElement) == 1)){
            minStack.pop();
        }

        Integer count = counterMap.getOrDefault(removedElement, 0) - 1;
        counterMap.put(removedElement, count);
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


public class Tester{
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
