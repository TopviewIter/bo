package com.xluo.arithmetic.number;

import java.util.ArrayList;

/**
 * [孩子们的游戏(圆圈中最后剩下的数)]
 * 每年六一儿童节,NowCoder都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为NowCoder的资深元老
 * ,自然也准备了一些小游戏。其中,有个游戏是这样的
 * :首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m的那个小朋友要出列唱首歌
 * ,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演
 * ,并且拿到NowCoder名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？
 * 思路:弄一个计数器记录小朋友的报号数,当==m时则remove,但要注意i--,因为remove的同时进行了移位,后一位补上了前一位
 * 为了循环遍历:使用取%的办法,让i永远不会越界
 * @author luozhangjie
 *
 */
public class LastNum {

	public static int lastRemaining_Solution(int n, int m) {
		if (n <= 0 || m < 0) {
			return -1;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		for (int i = 0, time = 0; list.size() != 1; i = (++i % list.size())) {
			if (++time == m) { // 报数从[1, m],如果按题意是从[0, m-1]
				list.remove(i);
				i--;
				time = 0;
			}
		}
		return list.get(0);
	}

	public static void main(String[] args) {

		System.out.println(lastRemaining_Solution(1, 0));
		System.out.println(lastRemaining_Solution(2, 2));
		System.out.println(lastRemaining_Solution(5, 7));
		System.out.println(lastRemaining_Solution(5, 3));

	}

}
