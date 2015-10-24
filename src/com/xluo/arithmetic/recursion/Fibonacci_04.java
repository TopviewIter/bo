package com.xluo.arithmetic.recursion;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：对于这种有n个东西,通过不同的做法,求有多少种方法的题,要学会列举,然后从列举中找到规律
 * @author luozhangjie
 *
 */
public class Fibonacci_04 {

	public int RectCover(int target) {
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
