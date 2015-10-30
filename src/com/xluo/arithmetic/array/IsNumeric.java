package com.xluo.arithmetic.array;

/**
 * [表示数值的字符串]
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"
 * 都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 思路:主要是找到不是数字的下标,然后根据它来确定后面可以出现什么,不可以出现什么
 * @author luozhangjie
 *
 */
public class IsNumeric {

	public static boolean isNumeric(char[] str) {
		if (str.length == 0) {
			return false;
		}
		int begin = str[0] == '+' || str[0] == '-' ? 1 : 0;
		int index = isNumber(str, begin);
		if (index == str.length) {
			return true;
		} else if (str[index] == '.') {
			if(index == str.length - 1){
				return true;
			}else if (str[index + 1] < '0' || str[index + 1] > '9') {
				return false;
			}
			int sIndex = isNumber(str, index + 1);
			if(sIndex < str.length - 1 && (str[sIndex] == 'e' || str[sIndex] == 'E')){
				return behideE(str, sIndex);
			}else if(sIndex == str.length){
				return true;
			}
		} else if (index < str.length - 1 && (str[index] == 'e' || str[index] == 'E')) {
			return behideE(str, index);
		}
		return false;
	}

	private static boolean behideE(char[] str, int index) {
		int lIndex = index + 1 < str.length && (str[index + 1] == '+' || str[index + 1] == '-') ? index + 1 : index;
		if(isNumber(str, lIndex + 1) != str.length){
			return false;
		}
		return true;
	}

	private static int isNumber(char[] str, int i) {
		int j = i;
		for (; j < str.length; j++) {
			if (str[j] < '0' || str[j] > '9') {
				return j;
			}
		}
		return j;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isNumeric("+100".toCharArray()));
		System.out.println(isNumeric("5e2".toCharArray()));
		System.out.println(isNumeric("-123".toCharArray()));
		System.out.println(isNumeric("3.1416".toCharArray()));
		System.out.println(isNumeric("-1E-16".toCharArray()));
		System.out.println(isNumeric("12e".toCharArray()));
		System.out.println(isNumeric("1a3.14".toCharArray()));
		System.out.println(isNumeric("1.2.3".toCharArray()));
		System.out.println(isNumeric("+-5".toCharArray()));
		System.out.println(isNumeric("12e+4.3".toCharArray()));
		System.out.println(isNumeric("600.".toCharArray()));
	}
}
