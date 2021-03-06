package com.xluo.arithmetic.array;

/**
 * [顺时针打印矩阵]
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 思路:不要看成一个整体来打印,看成一个一个的圈来打印,重要的是还要分析出
 * 	从上到下、从右到左、从下到上的条件
 * @author luozhangjie
 *
 */
public class PrintArray {

	public void each(int[][] array, int column, int row) {
		if (array == null || array.length <= 0) {
			return;
		}
		int start = 0;
		while (start << 1 < row && start << 1 < column) {
			printArray(array, column, row, start);
			start++;
		}
	}

	private void printArray(int[][] array, int column, int row, int start) {
		int endX = column - 1 - start; // 列下标
		int endY = row - 1 - start; // 行下标
		// 从左到右
		for (int i = start; i <= endX; i++) {
			System.out.print(array[start][i] + " ");
		}
		// 从上到下
		if (start < endY) { // 如果要打印的圈不是只有一行,那么都有从上到下打印
			for (int i = start + 1; i <= endY; i++) {
				System.out.print(array[i][endX] + " ");
			}
		}
		// 从右到左
		if (start < endY && start < endX) { // 矩阵的规模必须至少有两行两列才会有从右到左
			for (int i = endX - 1; i >= start; i--) {
				System.out.print(array[endY][i] + " ");
			}
		}
		// 从下到上
		if (start + 1 < endY && start < endX) {
			for (int i = endY - 1; i > start; i--) {
				System.out.print(array[i][start] + " ");
			}
		}
	}

	public static void main(String[] args) {

		int[][] array = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 } };
		int[][] array_02 = new int[][]{ {1, 2}, {3, 4} };
		new PrintArray().each(array, 4, 3);
		System.out.println();
		new PrintArray().each(array_02, 2, 2);

	}

}
