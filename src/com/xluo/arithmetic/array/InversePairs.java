package com.xluo.arithmetic.array;

public class InversePairs {

	public static int inversePairs(int[] array) {
		if(array == null || array.length == 0){
			return 0;
		}
		int result = 0;
		for(int i = 0; i < array.length; i++){
			for(int j = i + 1; j < array.length; j++){
				if(array[i] > array[j]){
					result++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(inversePairs(new int[]{1, 2, 1, 1, 3, 2, 1}));
		
	}

}
