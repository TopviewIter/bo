package com.xluo.arithmetic.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * [字符串的排列]
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb
 * ,bac,bca,cab和cba。 结果请按字母顺序输出。
 * 思路:把整个字符串分成两个部分,一个是第一个字符,一个是剩下的部分,然后让第一个字符与后面的进行交换
 * 	这时候仍要把后面的字符分成两部分,然后后面字符的第一个再与剩下的进行交换,如此递归。一直递归到只剩下
 * 	一个元素,然后它完成操作后,再轮到上一个序列,然后再到上上个序列,如此层层返回
 * 如：abc -> (ab)c(c与自己交换,此时i=index)
 * 			 (a)cb(i++,b与c进行交换)
 * 			 bac(a与b交换)
 * 			 ...
 * 			 cba(a与c交换)
 * 			 ...
 * 	  对于a(i=index时,包含了:abc、acb),对于b(i=index时,包含了:bc,然后i++出现cb),对于c(i=index时,包含:c)
 *   子序列均完成循环后,a的循环中:i++,a与b进行交换
 *   (固定一个元素,求剩下元素的全排列)
 * @author luozhangjie
 *
 */
public class StringSwap {

	public ArrayList<String> Permutation(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> r = new ArrayList<String>();
		permutation(str.toCharArray(), 0, r);
		Collections.sort(r);
		return r;
	}

	private void permutation(char[] charArray, int index,
			ArrayList<String> result) {
		if (index == charArray.length - 1) { //子序列完成全排列时,也会进入这个if块
			result.add(new String(charArray)); 
		}

		for (int i = index; i < charArray.length; i++) {
			if (charArray[i] != charArray[index] || i == index) {
				swap(charArray, i, index);
				permutation(charArray, index + 1, result);
				swap(charArray, i, index);
			}
		}
	}

	private void swap(char[] charArray, int a, int b) {
		if (a != b) {
			charArray[a] = (char) (charArray[a] ^ charArray[b]);
			charArray[b] = (char) (charArray[a] ^ charArray[b]);
			charArray[a] = (char) (charArray[a] ^ charArray[b]);
		}
	}

	public static void main(String[] args) {
		ArrayList<String> result = new StringSwap().Permutation("abc");
		for (String s : result) {
			System.out.println(s);
		}
	}

}
