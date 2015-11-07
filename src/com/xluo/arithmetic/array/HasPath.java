package com.xluo.arithmetic.array;

public class HasPath {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		int flag[] = new int[matrix.length]; //标识已经访问过的位置
		//通过遍历的方式来找起点
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(checkPath(matrix, rows, cols, str, i, j, 0, flag)){
					return true;
				}
			}
		}
		return false;
	}

	//通过递的方式来找路径
	private boolean checkPath(char[] matrix, int rows, int cols, char[] str,
			int i, int j, int k, int[] flag) {
		int index = i * cols + j;
		if(i < 0 || j < 0 || i >= rows || j >= cols 
				|| str[k] != matrix[index] || flag[index] == 1)
			return false;
		if(k == str.length - 1)return true;
		flag[index] = 1;
		if(checkPath(matrix, rows, cols, str, i - 1, j, k + 1, flag)
				|| checkPath(matrix, rows, cols, str, i + 1, j, k + 1, flag)
				|| checkPath(matrix, rows, cols, str, i, j - 1, k + 1, flag)
				|| checkPath(matrix, rows, cols, str, i, j + 1, k + 1, flag))
			return true;
		flag[index] = 0;
		return false;
	}

}
