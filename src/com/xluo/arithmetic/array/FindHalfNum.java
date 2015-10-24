package com.xluo.arithmetic.array;

/**
 * 数组中出现次数超过一半的数字
 * 水王问题
 * 思路：每次减掉两个不同的数,那么剩下的肯定是水王
 * 扩展：
 * @author luozhangjie
 *
 */
public class FindHalfNum {

	public int MoreThanHalfNum_Solution(int [] array) {
        int result = array[0]; //default reuslt
        int next; //compare to default
        int num = 1;
        for(int i = 1; i < array.length; i++){
            next = array[i];
            if(result == next){
                num++;
            }else{
                num--;
            }
            if(num == 0){
                result = array[++i];
                num++;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(new FindHalfNum().MoreThanHalfNum_Solution(new int[]{4,4,3,4,4,2,5,4,2}));;
	}
	
}
