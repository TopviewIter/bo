package com.xluo.arithmetic.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MakeMinNum {

	public static String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0){
            return "";
        }
		String result = "";
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < numbers.length; i++){
			nums.add(numbers[i]);
		}
		Collections.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s1.compareTo(s2);
			}
		});
		for(Integer i : nums){
			result += i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(PrintMinNumber(new int[]{3, 32, 321}));
		
	}
	
}
