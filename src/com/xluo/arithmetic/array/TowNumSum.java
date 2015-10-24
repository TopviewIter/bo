package com.xluo.arithmetic.array;

import java.util.ArrayList;

/**
 * [和为S的两个数字] 
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路:因为它是一个递增数组,那么可以想到用前后下标的方式来求和(一个指向0,一个指向array.length - 1,求和后,根据值来
 * 	一步步逼进结果,因为会存在多对这样的数,而结果要返回两个乘积最小的数,恰好第一次找到的就是乘积最小的数)
 * @author luozhangjie
 *
 */
public class TowNumSum {

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (array == null || array.length == 0) {
			return result;
		}
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			if (array[i] + array[j] == sum) {
				result.add(array[i]);
				result.add(array[j]);
				return result;
			} else if (array[i] + array[j] < sum) {
				i++;
			} else {
				j--;
			}

		}
		return result;

	}

}
