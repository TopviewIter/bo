package com.xluo.arithmetic.number;

import java.util.ArrayList;

/**
 * [丑数] 
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 	习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 思路：最直接的就是用不断取模的方式来解,但这样会导致不是丑数的数我们也要进行处理,当数据量大的时候就会导致性能。
 * 	第二种思路是：丑数必然是之前的丑数通过*2/*3/*5得到的,那么我们如果只对这些数进行处理,效率肯定会高很多。
 * 	但有一个问题就是如果确定让得到的这些丑数按顺序排着。这时就要用到3个下标,分别用来标识那些值是已经被用来*2/*3/*5
 * 	的,那么下一次只要分别取下标对应的值再*2/*3/*5,取其中的最小值即可。	
 * @author luozhangjie
 *
 */
public class UglyNumber {

	public static int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		}
		int p1 = 0;
		int p3 = 0;
		int p5 = 0;
		int[] uglyNums = new int[index];
		uglyNums[0] = 1;
		for (int i = 1; i < uglyNums.length; i++) {
			uglyNums[i] = min(uglyNums[p1] * 2, uglyNums[p3] * 3,
					uglyNums[p5] * 5);
			// 让之前的数*2,当p1++时,表示当前的这个值*2的值已经在数组中了,因为每次选取的都是p2、p3、p5中的最小值
			while (uglyNums[p1] * 2 <= uglyNums[i])
				p1++;
			// 让之前的数*3
			while (uglyNums[p3] * 3 <= uglyNums[i])
				p3++;
			// 让之前的数*5
			while (uglyNums[p5] * 5 <= uglyNums[i])
				p5++;
		}
		return uglyNums[index - 1];
	}

	private static int min(int a, int b, int c) {
		int min = a < b ? a : b;
		min = min < c ? min : c;
		return min;
	}

	public static int GetUglyNumber_Solution_01(int index) {
		if (index <= 0) {
			return 0;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i = 1;
		while (true) {
			if (isUglyNum(i)) {
				result.add(i);
			}
			i++;
			if (result.size() == index) {
				break;
			}
		}
		return result.get(result.size() - 1);
	}

	private static boolean isUglyNum(int num) {
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		if (num == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println(GetUglyNumber_Solution_01(11));
		System.out.println(GetUglyNumber_Solution(11));

	}
}
