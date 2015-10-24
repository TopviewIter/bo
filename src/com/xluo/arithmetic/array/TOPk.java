package com.xluo.arithmetic.array;

import java.util.ArrayList;
import java.util.List;

public class TOPk {

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (input == null || k == 0 || k > input.length) {
			return result;
		}
		for (int i = 0, j = 0; i < input.length; i++) {
			buildMinHead(input, input.length - 1 - i);
			result.add(input[0]);
			input[0] = input[0] ^ input[input.length - 1 - i];
			input[input.length - 1 - i] = input[0] ^ input[input.length - 1 - i];
			input[0] = input[0] ^ input[input.length - 1 - i];
			j++;
			if (j == k) {
				break;
			}
		}
		return result;
	}

	private void buildMinHead(int[] array, int lastIndex) {
		for (int i = (lastIndex - 1) >> 1; i >= 0; i--) {
			int k = i;
			while (2 * k + 1 <= lastIndex) {
				int minIndex = 2 * k + 1;
				if (minIndex < lastIndex) {
					if (array[minIndex] > array[minIndex + 1]) {
						minIndex++;
					}
				}
				if (array[minIndex] < array[k]) {
					array[minIndex] = array[minIndex] ^ array[k];
					array[k] = array[minIndex] ^ array[k];
					array[minIndex] = array[minIndex] ^ array[k];
					k = minIndex;
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {

		List<Integer> result = new TOPk().GetLeastNumbers_Solution(new int[] {
				4, 5, 1, 6, 2, 7, 3, 8 }, 4);
		if (result != null && result.size() != 0) {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}

	}

}
