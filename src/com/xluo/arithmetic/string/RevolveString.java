package com.xluo.arithmetic.string;

/**
 * [左旋转字符串] 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出
 * 。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 思路:第一种方案是第次循环一位,但这样效率必然会很低。
 * 	第二种方案是源于字符串的翻转,我们把整个字符串看成两部分,先全部翻转再进行部分翻转即可得到结果。
 * @author luozhangjie
 *
 */
public class RevolveString {

	public static String leftRotateString(String str, int n) {
		if (str == null || n < 0 || str.length() == 1 || "".equals(str)
				|| n > str.length() - 1) {
			return str;
		}
		char[] s = str.toCharArray();
		for (int i = n, j = 0; i > 0; i--) {
			char temp = s[i - 1];
			int index = i;
			do {
				s[index - 1] = s[index];
				index++;
			} while (index < s.length - j);
			j++;
			s[index - 1] = temp;
		}
		return String.valueOf(s);
	}

	public static String leftRotateString_02(String str, int n){
		if (str == null || n < 0 || str.length() == 1 || "".equals(str)
				|| n > str.length() - 1) {
			return str;
		}
		char[] aim = str.toCharArray();
		reverseString(aim, 0, aim.length - 1);
		reverseString(aim, 0, aim.length - 1 - n);
		reverseString(aim, aim.length - n, aim.length - 1);
		return String.valueOf(aim);
	}
	
	private static void reverseString(char[] array, int begin, int end){
		for(int i = begin, j = end; i < j; i++, j--){
			array[i] = (char) (array[i] ^ array[j]);
			array[j] = (char) (array[i] ^ array[j]);
			array[i] = (char) (array[i] ^ array[j]);
		}
	}
	
	public static void main(String[] args) {

		System.out.println(leftRotateString("abcXYZdef", 3));
		System.out.println(leftRotateString_02("abcXYZdef", 3));

	}

}
