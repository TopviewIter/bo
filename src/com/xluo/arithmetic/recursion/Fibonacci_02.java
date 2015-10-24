package com.xluo.arithmetic.recursion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author luozhangjie
 *
 */
public class Fibonacci_02 {

	public int JumpFloor(int target) {
		if(target == 1 || target == 0){
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        while(target-- >= 2){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
	
}
