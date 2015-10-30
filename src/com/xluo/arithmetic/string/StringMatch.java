package com.xluo.arithmetic.string;

/**
 * 这里主要是学会熟练地操纵char[],因为它并不会像c/c++那样,数组是以char[i] == '/0'来结束的
 * 对于java只有判断长度是否越界
 * @author luozhangjie
 *
 */
public class StringMatch {

	public static boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null){
			return false;
		}
		return matchEach(str, pattern, 0, 0);
	}
	
	private static boolean matchEach(char[] str, char[] pattern, int i, int j) {
		if(i == str.length && j == pattern.length){
			return true;
		}
		if(j + 1 < pattern.length && i <= str.length){
			if(pattern[j + 1] == '*'){
				if(i < str.length && (str[i] == pattern[j] || pattern[j] == '.')){
					return matchEach(str, pattern, i, j + 2) //a*ab ab
							|| matchEach(str, pattern, i + 1, j + 2) //a*b ab
							|| matchEach(str, pattern, i + 1, j); //a*b aab
				}else{
					return matchEach(str, pattern, i, j + 2); //b*ab ab
				}
			}
		}
		if(i < str.length && j < pattern.length){
			if(str[i] == pattern[j] || (pattern[j] == '.')){
				return matchEach(str, pattern, i + 1, j + 1);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
//		System.out.println(match("aaa".toCharArray(), "aa.a".toCharArray()));
//		System.out.println(match("aaa".toCharArray(), "aa".toCharArray()));
//		System.out.println(match("aaa".toCharArray(), "a.a".toCharArray()));
		System.out.println(match("aaa".toCharArray(), "aa..".toCharArray()));
		System.out.println(match("aaab".toCharArray(), "*a*b".toCharArray()));
		System.out.println(match("".toCharArray(), ".*".toCharArray()));
		
	}

}
