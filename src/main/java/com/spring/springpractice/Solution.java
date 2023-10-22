package com.spring.springpractice;

import java.util.*;
class Solution {

    Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for(String str : tokens){
            switch (str){
                case "+": {
                    int operandTwo = stack.pop();
                    int operandOne = stack.pop();

                    stack.push(add(operandOne, operandTwo));
                    break;
                }
                case "-": {
                    int operandTwo = stack.pop();
                    int operandOne = stack.pop();

                    stack.push(subtract(operandOne, operandTwo));
                    break;
                }
                case "/": {
                    int operandTwo = stack.pop();
                    int operandOne = stack.pop();

                    stack.push(divide(operandOne, operandTwo));
                    break;
                }
                case "*": {
                    int operandTwo = stack.pop();
                    int operandOne = stack.pop();

                    stack.push(multiply(operandOne, operandTwo));
                    break;
                }
                default:{
                    stack.push(Integer.parseInt(str));
                }
            }
        }
        return stack.pop();
    }

    public int add(int operandOne, int operandTwo){
        return operandOne + operandTwo;
    }

    public int subtract(int operandOne, int operandTwo){
        return operandOne - operandTwo;
    }

    public int multiply(int operandOne, int operandTwo){
        return operandOne * operandTwo;
    }

    public int divide(int operandOne, int operandTwo){
        return operandOne / operandTwo;
    }
}
