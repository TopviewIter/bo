package com.xluo.test;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		for(Integer i : s){
			System.out.println(i);
		}
		
	}
	
}
