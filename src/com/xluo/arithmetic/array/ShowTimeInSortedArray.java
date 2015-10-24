package com.xluo.arithmetic.array;

public class ShowTimeInSortedArray {

	public static int GetNumberOfK(int [] array , int k) {
		if(array == null || array.length == 0){
			return 0;
		}
		int start = 0;
		int end = array.length - 1;
		int result = 0;
		while(start <= end){
			int mid = (start + end) >> 1;
			if(array[mid] < k){
				start = mid + 1;
			}else if(array[mid] > k){
				end = mid - 1;
			}else{
				result++;
				for(int i = mid - 1; i >= 0; i--){ //往前找
					if(array[i] == k){
						result++;
					}
				}
				for(int i = mid + 1; i < array.length; i++){ //往后找
					if(array[i] == k){
						result++;
					}
				}
				return result;
			}
		}
		return 0;
    }
	
	public static void main(String[] args) {
		
		System.out.println(GetNumberOfK(new int[]{1, 3, 3, 3, 3, 4, 5}, 6));
		
	}
	
}
