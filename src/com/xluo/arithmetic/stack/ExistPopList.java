package com.xluo.arithmetic.stack;

import java.util.Stack;

/**
 * [栈的压入、弹出序列]
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 	假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 	序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 思路:定义一个栈道,按照入栈序列进栈,当遇到值与出栈序列中相等时就出栈,当出栈后,可能栈顶的元素刚好
 * 	等于出栈数组中的下一个元素,因而用一个while判断栈顶的元素是否等于下一个出栈的元素。若不是则
 * 	把剩下没有进栈的元素继续进栈。
 * 结论:如果进栈完成后,栈的大小刚好为0(因为进栈的同时,也按照出栈的数组进行了出栈),那么说明出栈序列是对的
 * 	反之则不是
 * @author luozhangjie
 *
 */
public class ExistPopList {

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || pushA.length == 0 || popA == null
				|| popA.length == 0) {
			return false;
		}
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0, j = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
			while (!s.empty() && s.peek() == popA[j]) {
				s.pop();
				j++;
			}
		}
		boolean result = s.size() == 0 ? true : false;
		return result;
	}

	public static void main(String[] args) {

		System.out.println(IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] {
				4, 5, 3, 2, 1 }));
		System.out.println(IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] {
				4, 3, 5, 1, 2 }));

	}
}
