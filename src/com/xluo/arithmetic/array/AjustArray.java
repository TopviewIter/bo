package com.xluo.arithmetic.array;


/**
 * [调整数组顺序使奇数位于偶数前面]
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
 * ，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author luozhangjie
 *
 */
public class AjustArray{
	
	public void reOrderArray(int[] array) {
		int[] temp = new int[array.length];
		int k = 0; // array index
		for (int i = 0, j = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				temp[j++] = array[i];
			} else {
				array[k++] = array[i];
			}
		}
		for (int n = k, j = 0; n < array.length; n++) {
			array[n] = temp[j++];
		}

	}

}
