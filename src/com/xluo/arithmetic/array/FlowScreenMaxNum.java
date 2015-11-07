package com.xluo.arithmetic.array;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * [滑动窗口的最大值]
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。 
 * 思路:
 * 方法一:求出每个窗口的最大值再保存即可(蛮力法)
 * 方法二:使用双端队列,保存当前窗口的最大值与及后面窗口的可能最大值
 * @author luozhangjie
 *
 */
public class FlowScreenMaxNum {

	public static ArrayList<Integer> maxInWindows_01(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		if (size == 0)
			return res;
		int begin; //begin当前窗口的起点,i是当前窗口的终点
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < num.length; i++) {
			begin = i - size + 1;
			if (q.isEmpty())
				q.add(i);
			if (begin > q.peekFirst())
				q.pollFirst();

			//当num[q.peekLast()] <= num[i]时,那么num[i]必然是这一个窗口的最大值,因而可以把队列中比它小的数去掉
			//当num[q.peekLast()] > num[i]时,那么num[i]可能是下一个窗口的最大值
			while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
				q.pollLast();
			q.add(i);
			if (begin >= 0)
				res.add(num[q.peekFirst()]);
		}
		return res;
	}

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (num == null || num.length == 0 || size == 0) {
			return result;
		}
		int screenNum = num.length - (size - 1);
		int start = 0;
		int end = size;
		while (screenNum-- != 0) {
			result.add(getMax(num, start++, end++));
		}
		return result;
	}

	public int getMax(int[] num, int i, int j) {
		int max = num[i];
		for (int k = i + 1; k < j; k++) {
			max = num[k] > max ? num[k] : max;
		}
		return max;
	}

	public static void main(String[] args) {

		ArrayList<Integer> result = maxInWindows_01(new int[] { 1, 2, 3, 1, 2,
				4, 1 }, 3);
		if (result.size() != 0) {
			for (Integer i : result) {
				System.out.println(i);
			}
		}

	}

}
