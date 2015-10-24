package com.xluo.arithmetic.stack;

import java.util.Stack;

/**
 * [用两个栈实现队列]
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：首先分析如何使用这两个栈可以实现队列的功能
 * 	1、当只有一个元素,那么不用借助第二个栈(要检测B栈是否为空,因为可能存在A中只有一个元素,但B不为空的状态)
 * 	2、当有多个元素,那么就把A栈的元素都push到B中,那么再让B直接pop就行,当B为空时,就从A中拿元素
 * @author luozhangjie
 *
 */
public class StackToQueue {

	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack1.size() == 1 && stack2.size() == 0){
            return stack1.pop();
        }else if(stack2.size() == 0){
            popToOtherStack(stack1, stack2);
        }
        return stack2.pop();
    }
    
    private void popToOtherStack(Stack<Integer> s1, Stack<Integer> s2){
    	while(s1.size() != 0){
    		s2.push(s1.pop());
    	}
    }
    
    public static void main(String[] args) {
    	StackToQueue stq = new StackToQueue();
    	stq.push(1);
    	stq.push(2);
    	stq.push(3);
    	System.out.println(stq.pop());
    	System.out.println(stq.pop());
    	stq.push(4);
    	System.out.println(stq.pop());
    	stq.push(5);
    	System.out.println(stq.pop());
    	System.out.println(stq.pop());
	}
}
