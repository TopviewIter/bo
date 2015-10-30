package com.xluo.arithmetic.array;

import java.util.Arrays;

/**
 * [构建乘积数组]
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*
 * A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 思路:这里一开始想到的是O(n^2)的方法,但这样效率肯定会很低,不可取。还有一种方法就是先求A[0-(i-1)]与
 * A[i-(n-1)],再将它们相乘,有一个思维困境就是如果i是确定的那么很简单,但它的i是不确定的。要怎么在一次循环
 * 中同时实现求出A[0-(i-1)]与A[i-(n-1)]?这里没有想到可以分步来求,也就是先把所有B[i]的A[0-(i-1)],
 * 然后在另一个循环中求解A[i-(n-1)]
 * @author luozhangjie
 *
 */
public class MultiplyArray {

	public static int[] multiply(int[] A) {
		if (A == null || A.length == 0) {
			return A;
		}
		int[] B = new int[A.length];
		int rect = 1;
		for (int i = 0; i < A.length; rect *= A[i++]) {
			B[i] = rect;
		}
		rect = 1;
		for (int i = A.length - 1; i >= 0; rect *= A[i--]) {
			B[i] *= rect;
		}
		return B;
	}

	public static void main(String[] args) {

		System.out.println(Arrays.toString(multiply(new int[] { 1, 2, 3, 4 })));

	}

}
