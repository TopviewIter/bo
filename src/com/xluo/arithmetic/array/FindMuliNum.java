package com.xluo.arithmetic.array;

import java.util.HashMap;
import java.util.Map;

/**
 * [数组中重复的数字] 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * 思路:要记录数组重复数字的情况,可以使用哈希表。哈希表一般用来保存映射关系,也可以用于去重 
 * @author luozhangjie
 *
 */
public class FindMuliNum {

	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || numbers.length == 0 || numbers.length < length) {
			return false;
		}
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			if (!result.containsKey(numbers[i])) {
				result.put(numbers[i], 1);
			} else {
				duplication[0] = numbers[i];
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int[] result = new int[1];
		System.out.println(duplicate(new int[] { 2, 3, 1, 0, 2, 5, 3 }, 7,
				result));
		System.out.println(result[0]);

	}

}
