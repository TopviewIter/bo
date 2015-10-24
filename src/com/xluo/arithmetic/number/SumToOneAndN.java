package com.xluo.arithmetic.number;

/**
 * [求1+2+3+...+n]
 * 在剑指offer当中介绍了使用构造方法的方式来求解,但它并不适用于java,因为那时对象还没初始化,构造函数
 * 还没有执行。又因题目不能使用循环与判断,那么可以使用递归,但什么时候停止递归呢?这里使用的是短路的方法。
 * @author luozhangjie
 *
 */
public class SumToOneAndN {
	
	@SuppressWarnings("unused")
	public static int Sum_Solution(int n) {
		int sum = n;
		boolean temp = sum > 0 && (sum += Sum_Solution(n - 1)) > 0;
		return sum;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Sum_Solution(100));
	}
}
