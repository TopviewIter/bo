package com.xluo.arithmetic.array;

/**
 * [二维数组中的查找]
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author luozhangjie
 *
 */
public class ArrayFindNum {

	//最直接的方式
	public boolean Find_01(int [][] array,int target) {
		for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
	
	//从左上角出发，
	//如果数组中的元素比它小，则目标不可能出现在该行的左边，那么就换行
	//如果数组中的元素比它大，则目标不可能出现在该列的下方，那么就换列
	public boolean Find_02(int [][] array, int target){
		int i = 0;
        int j = array[0].length - 1;
        while(j >= 0 && i < array.length){
            if(array[i][j] < target){
                i++;
            }else if(array[i][j] > target){
                j--;
            }else{
                return true;
            }
        }
        return false;
	}
	
	public static void main(String[] args) {
		int[][] a = new int[][]{
				{1, 2, 8, 9},
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}
		};
		System.out.println(new ArrayFindNum().Find_02(a, 7));
	}
}
