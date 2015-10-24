package com.xluo.arithmetic.number;

import java.util.ArrayList;

/**
 * [和为S的连续正数序列]
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 思路:这个序列最少要有两个数,而且是有序的无间隔的,那么就可以从1开始,一组一组地把结果找出来
 * 	第二种写法的思路是:对第一种的一种优化,因为在相加的过程中,如果是第一种写法,当result > sum,
 * 	是直接重新取small再从头开始算的,但很大的一部分是前一次累加已经相加过了,那么可以使result - small
 * 	的方式,来找到small的下一个适当的值(这时small的值使得result < sum || result == sum)
 * @author luozhangjie
 *
 */
public class FindContinuousSequence {

	public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
		
		ArrayList<ArrayList<Integer>> aai = new ArrayList<ArrayList<Integer>>();
		for (int small = 1; small < (sum + 1) >> 1; small++) {
			int result = small;
			int big = small + 1;
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(small);
			while (result < sum) {
				result += big;
				l.add(big);
				big++;
			}
			if(result == sum){ //判断是否刚好等于sum,因为跳出while的时候result可能已经大于sum了
				aai.add(l);
			}
		}
		return aai;
		
	}

	public static ArrayList<ArrayList<Integer>> findContinuousSequence_02(int sum){
		
		ArrayList<ArrayList<Integer>> aai = new ArrayList<ArrayList<Integer>>();
		int small = 1;
		int big = small + 1;
		int result = small;
		while(small < (sum + 1) >> 1){
			result += big;
			if(result == sum){
				aai.add(getList(small, big));
			}
			//进行了一个优化,因为当result>sum时,如果我们直接重新取small值,那么又得从头开始计算,那么我只要让small
			//的值取到result == sum 或result < sum的地方,那么就不用再重新计算这个区间的值了
			while(result > sum){
				result -= small;
				small++;
				if(result == sum && small != big){
					aai.add(getList(small, big));
				}
			}
			big++;
		}
		return aai;
		
	}
	
	private static ArrayList<Integer> getList(int small, int big) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = small; i <= big; i++){
			result.add(i);
		}
		return result;
	}

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> result = findContinuousSequence(3);
		if(result.size() != 0){
			for(ArrayList<Integer> ai : result){
				for(Integer i : ai){
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
		
		System.out.println("=============================================");
		
		ArrayList<ArrayList<Integer>> result_02 = findContinuousSequence_02(3);
		if(result_02.size() != 0){
			for(ArrayList<Integer> ai : result_02){
				for(Integer i : ai){
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
		
	}
	
}
