package com.xluo.arithmetic.string;

import java.util.HashMap;
import java.util.Map;

/**
 * [第一个只出现一次的字符位置]
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。若为空串，返回-1。位置索引从0开始
 * 思路:这里要求字符只出现一次的下标,那么我们就要记录下各个字符出现的次数,那么再次遍历这个字符串的时候就可以找到只出现
 * 	一次的字符,问题是如果保存各个字符出现的次数,字符-次数:明显的key-value,那么就可以用哈希表来做
 * @author luozhangjie
 *
 */
public class FirstNotRepeatChar {

	public static int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] c = str.toCharArray();
		for(int i = 0; i < c.length; i++){
			if(map.containsKey(c[i])){
				Integer num = map.get(c[i]);
				map.put(c[i], ++num);
			}else{
				map.put(c[i], 1);
			}
		}
		for(int i = 0; i < c.length; i++){
			if(map.get(c[i]) == 1){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		System.out.println(FirstNotRepeatingChar("aaabbbcaaabb"));
		
	}

}
