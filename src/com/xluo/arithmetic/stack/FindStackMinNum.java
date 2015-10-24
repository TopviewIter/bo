package com.xluo.arithmetic.stack;

import java.util.Stack;

/**
 * [包含min函数的栈]
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：借助一个辅助栈,用来存储栈当中的最小元素。当辅助栈为空时,元素直接push进去
 * 	当不为空时,将要push到栈当中的值与辅助栈中的栈顶元素比较,如果比它小则直接进入,
 * 	如果比它大或等于则辅助栈的栈顶元素重复进入辅助栈
 * @author luozhangjie
 *
 */
public class FindStackMinNum {

	private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();
    
    public void push(int node) {
        s1.push(node);
        if(s2.empty()){
            s2.push(node);
        }else{
            if(node < s2.peek()){
                s2.push(node);
            }else{
                s2.push(s2.peek());
            }
        }
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int min() {
        return s2.peek();
    }
	
}
