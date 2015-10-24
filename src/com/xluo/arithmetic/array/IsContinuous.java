package com.xluo.arithmetic.array;


public class IsContinuous {

	public static boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length != 5){
			return false;
		}
		quickSort(numbers, 0, numbers.length - 1);
		int zeroNum = 0;
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] == 0){
				zeroNum++;
			}
		}
		for(int i = zeroNum; i < numbers.length - 1; i++){
			if(numbers[i] == numbers[i + 1]){
				return false;
			}
			int middleNum = numbers[i + 1] - numbers[i];
			if(middleNum != 1 && zeroNum >= middleNum - 1){
				zeroNum -= (middleNum - 1);
			}else if(zeroNum < middleNum - 1){
				return false;
			}
		}
		return true;
    }
	
	private static void quickSort(int[] array, int start, int end){
		if(start < end){
			int i = start;
			int j = end + 1;
			int base = array[start];
			while(true){
				while(i < end && array[++i] <= base);
				while(j > start && array[--j] >= base);
				if(i < j){
					array[i] = array[i] ^ array[j];
					array[j] = array[i] ^ array[j];
					array[i] = array[i] ^ array[j];
				}else{
					break;
				}
			}
			if(start != j){
				array[start] = array[start] ^ array[j];
				array[j] = array[start] ^ array[j];
				array[start] = array[start] ^ array[j];
			}
			
			quickSort(array, start, j - 1);
			quickSort(array, j + 1, end);
			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(isContinuous(new int[]{1, 2, 3, 5, 6}));
		System.out.println(isContinuous(new int[]{0, 1, 2, 5, 3}));
		System.out.println(isContinuous(new int[]{0, 3, 2, 5, 3}));
		System.out.println(isContinuous(new int[]{1, 3, 0, 5, 0}));
		
	}
	
}
