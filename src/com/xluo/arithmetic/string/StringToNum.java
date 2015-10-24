package com.xluo.arithmetic.string;

/**
 * [把字符串转换成整数]
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 思路:最主要的就是不合法情况的排除
 * @author luozhangjie
 *
 */
public class StringToNum {

	public static int strToInt(String str) {
		if(str == null || "".equals(str) || ((str.startsWith("+") || str.startsWith("-")) && str.length() == 1)){
			return 0;
		}
		String sign = "";
		char[] nums = str.toCharArray();
		if(str.startsWith("+") || str.startsWith("-")){
			sign = str.substring(0, 1);
		}
		int i = "".equals(sign) ? 0 : 1;
		int result = 0;
		while(i < nums.length){
			if("0123456789".indexOf(String.valueOf(nums[i])) < 0){
				return 0;
			}
			result = result * 10 + (nums[i] - 48); //这里把char转成对应的数字
			i++;
		}
		if("-".equals(sign)){
			return -result;
		}else{
			return result;
		}
	}

	public static void main(String[] args) {
		
		System.out.println(strToInt("++00123"));
		System.out.println(strToInt("+00123"));
		System.out.println(strToInt("-00123"));
		System.out.println(strToInt("++00+1-23"));
		
	}
	
}
