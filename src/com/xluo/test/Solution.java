package com.xluo.test;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	
	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
		}
		for (int i = 0; i < popA.length; i++) {
			if (popA[i] == s.peek()) {
				s.pop();
			} else {
				// not the same
				while(popA[i] != s.peek()){
					list.add(s.pop());
				}
				s.pop();
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
	}
}