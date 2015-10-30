package com.xluo.arithmetic.string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * [字符流中第一个不重复的字符]
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是
 * "g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 思路:出现字符与次数的映射用哈希表,但这里要记录插入的顺序,所以要使用到linkedHashMap 
 * linkedHashMap实际上就是一个双向循环链表
 * @author luozhangjie
 *
 */
public class FirstNotRepeatCharInStream {

	private static LinkedHashMap<Character, Integer> table = new LinkedHashMap<Character, Integer>();

	// Insert one char from stringstream
	public static void Insert(char ch) {
		if (table.get(ch) == null) {
			table.put(ch, 1);
		} else {
			table.put(ch, table.get(ch) + 1);
		}
	}

	// return the first appearence once char in current stringstream
	public static char FirstAppearingOnce() {
		Iterator<Entry<Character, Integer>> iter = table.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Character, Integer> entry = iter.next();
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return '#';
	}

	public static void main(String[] args) {

		char[] text = "BabyBaby".toCharArray();
		for (int i = 0; i < text.length; i++) {
			Insert(text[i]);
			System.out.print(FirstAppearingOnce());
		}
	}
}
