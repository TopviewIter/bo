package com.xluo.arithmetic.number;

/**
 * [数值的整数次方]
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author luozhangjie
 *
 */
public class Power {
	
	public static double power(double base, int exponent) {
		if (base == 1 || exponent == 0) {
			return 1;
		} else if (base == 0) {
			return 0;
		} else if (exponent == 1) {
			return 1;
		}
		if (exponent < 0) {
			double result = 1;
			for (int i = 1; i <= -exponent; i++) {
				result *= base;
			}
			return 1 / result;
		} else {
			double result = 1;
			for (int i = 1; i <= exponent; i++) {
				result *= base;
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(power(2, 3));
	}
}
