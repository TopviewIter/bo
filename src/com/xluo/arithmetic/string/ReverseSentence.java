package com.xluo.arithmetic.string;

/**
 * [翻转单词顺序列]
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看
 * ，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a
 * student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 思路:先翻转整个字符串再逐个翻转单词
 * @author luozhangjie
 *
 */
public class ReverseSentence {

	public static String reverseSentence(String str) {
		// "".equals(str.trim()):防止字符串全是空格的情况
		if (str == null || str.length() == 0 || "".equals(str.trim())) {
			return str;
		}
		char[] sentence = str.toCharArray();
		// 整个句子交换
		for (int i = 0, j = sentence.length - 1; i <= (sentence.length - 1) >> 1
				&& i != j; i++, j--) {
			swap(sentence, i, j);
		}
		String[] eachWord = String.valueOf(sentence).split(" ");
		StringBuilder sb = new StringBuilder();
		for (String s : eachWord) {
			char[] word = s.toCharArray();
			for (int i = 0, j = word.length - 1; i <= (word.length - 1) >> 1
					&& i != j; i++, j--) {
				swap(word, i, j);
			}
			sb.append(String.valueOf(word) + " ");
		}
		String result = sb.toString();
		return result.substring(0, result.length() - 1);
	}

	private static void swap(char[] array, int i, int j) {
		array[i] = (char) (array[i] ^ array[j]);
		array[j] = (char) (array[i] ^ array[j]);
		array[i] = (char) (array[i] ^ array[j]);
	}

	public static void main(String[] args) {

		System.out.println(reverseSentence("I am a student."));
		System.out.println(reverseSentence("Is a word"));
		System.out.println(reverseSentence(" "));
		System.out.println(reverseSentence(" Is a word"));
		System.out.println(reverseSentence("    "));

	}

}
