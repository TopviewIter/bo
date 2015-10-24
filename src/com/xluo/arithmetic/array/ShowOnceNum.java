package com.xluo.arithmetic.array;

/**
 * [数组中只出现一次的数字]
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 思路:如果是只有一个数只出现了一次,其它数字出现多次,可以使用哈希表来做,但这里有个条件是其它数字只出现了两次,
 * 	而且要求时间复杂度为O(n),空间复杂度为O(1),那么不可能再使用哈希表来做。问题是,它为什么让其它数字只出现两
 * 	次呢?实际上有个知识点就是一个数与它自身进行异或运算时结果为0,那么当这个数组只有一个数只出现一次,那么我们只
 * 	需要把每个数都进行异或运算,得到的结果就是出现一次的数,因为其它的数都被对消掉了。但当有两个数字只出现一次呢?
 * 	我们可以把这个数组分成两组,但要保证出现两次的两个数要在同一组,由上面可知,如果我们对整个数组进行异或运算,实际
 * 	上就是那两个只出现一次的数进行异或运算的结果,因为其它的都对消掉了。那么我们分析这两个数异或后的结果,找到最右
 * 	出现的第一个1,说明两个数的这一位必定是一个为0、一个为1,那么我们可以依此把整个数组分成两组,这样就能保证相同
 * 	的数分在同一组,而且这两个数不会被分到同一组
 * 知识点: num & 1 == 0:用来判断这个数是不是以1结尾
 * @author luozhangjie
 *
 */
public class ShowOnceNum {

	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length == 0) {
			return;
		} else if (array.length == 1) {
			num1[0] = 0;
			num2[0] = 0;
			return;
		}
		int binaryResult = 0;
		for (int i = 0; i < array.length; i++) {
			binaryResult ^= array[i];
		}
		int index = findLastOneIndex(binaryResult);
		for (int i = 0; i < array.length; i++) {
			if (isOne(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	public static int findLastOneIndex(int binaryResult) {
		int index = 0;
		while ((binaryResult & 1) == 0) {
			binaryResult = binaryResult >> 1;
			index++;
		}
		return index;
	}

	public static boolean isOne(int num, int index) {
		return ((num >> index) & 1) == 0 ? false : true;
	}

	public static void main(String[] args) {
		
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		FindNumsAppearOnce(new int[]{1, 2, 2, 3}, num1, num2);
		System.out.println(num1[0] + "  -  " + num2[0]);
		
	}
	
}
