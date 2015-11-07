package com.xluo.arithmetic.array;

public class RobotMoveCount {

	public static int movingCount(int threshold, int rows, int cols) {
		int[] flag = new int[rows * cols];
		int count = hashPath(threshold, rows, cols, 0, 0, flag);
		return count;
	}

	private static int hashPath(int threshold, int rows, int cols, int i,
			int j, int[] flag) {
		int count = 0;
		if (cheakCell(threshold, rows, cols, i, j, flag)) {
			flag[i * cols + j] = 1; 
			count = 1 + hashPath(threshold, rows, cols, i - 1, j, flag)
					+ hashPath(threshold, rows, cols, i + 1, j, flag)
					+ hashPath(threshold, rows, cols, i, j - 1, flag)
					+ hashPath(threshold, rows, cols, i, j + 1, flag);
		}
		return count;
	}

	private static boolean cheakCell(int threshold, int rows, int cols, int i,
			int j, int[] flag) {
		if (i < 0 || j < 0 || i >= rows
				|| j >= cols || flag[i * cols + j] == 1
				|| getCount(i) + getCount(j) > threshold)
			return false;
		return true;
	}

	private static int getCount(int num) {
		int result = 0;
		while (num != 0) {
			result += num % 10;
			num /= 10;
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println(movingCount(15, 20, 20));

	}

}
