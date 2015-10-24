package com.xluo.arithmetic.recursion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 数学归纳法：f(n) = 2^(n-1)
 * @author luozhangjie
 *
 */
public class Fibonacci_03 {

	public static int JumpFloorII(int target) {
        int result = 1;
        while(--target > 0){
            result = result << 1;
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(JumpFloorII(1));
	}
	
}
