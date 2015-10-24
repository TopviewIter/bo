package com.xluo.arithmetic.number;

/**
 * [不用加减乘除做加法]
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author luozhangjie
 *
 */
public class SumWithOutAdd {

	public static int add(int num1, int num2) {
		int sum, carry;
		do{
			//异或运算中：00 -> 0, 11 -> 0, 10 -> 1, 01 -> 1,这恰好符合加法的原则,但这却无法体现进位的效果
			sum = num1 ^ num2; 
			//这里进行与运算就是为了找出那些位是要进行进位的,左移就是进位的效果
			carry = (num1 & num2) << 1;
			
			num1 = sum;
			num2 = carry;
		}while(num2 != 0); //进行循环是因为可能加上移位的效果后,可能还存在移位
		return num1;
	}
	
	public static void main(String[] args) {
		
		System.out.println(add(10, 1));
		
	}

}
