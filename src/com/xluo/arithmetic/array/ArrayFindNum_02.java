package com.xluo.arithmetic.array;

/**
 * [旋转数组的最小数字]
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减序列的一个旋转，输出旋转数组的最小元素。例如数组{3
 * ,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 
 * @author luozhangjie
 *
 */
public class ArrayFindNum_02 {

	public static int minNumberInRotateArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int start = 0;
		int end = array.length - 1;
		// 一开始就是一个有序数组
		if (array[start] < array[end]) {
			return array[start];
		}
		while (start < end) {
			int mid = (start + end) >> 1;
			// 当中间位置比开头大,说明最小值在[mid, end],因为array[start] >= array[end]
			if (array[mid] > array[start]) {
				start = mid;
				// 当中间位置比开头小,说明最小值在[start, mid]
			} else if (array[mid] < array[start]) {
				end = mid;
				// 因为start每次指向的值均是比最小值大,所以end最终指向最小值
			} else {
				// 当array[mid] == array[start],可能出现的情况:最小值在前[1, 0, 1,
				// 1],最小值在后[1, 1, 1, 0]
				if (array[start] == array[end]) {
					end--;
				} else {
					start = mid;
				}
			}
			if (end - start == 1) {
				return array[end];
			}
		}
		return array[end];
	}

	public static void main(String[] args) {
		System.out.println(minNumberInRotateArray(new int[] { 1, 0, 1, 1, 1 }));
	}
}
