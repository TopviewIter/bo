package com.xluo.arithmetic.number;

public class NumberOf1 {

	public static int numberOf1(int n) {
		int count = 0;
        while(n != 0){ //因为n可以是正负,通过不断减少1的过程,让n趋向于0
            count++;
            n = n & (n - 1); //这种写法会让这个数每次运算都会减少一个1
        }
        return count;
    }
	
	public static void main(String[] args) {
		System.out.println(numberOf1(3));
	}
	
}
