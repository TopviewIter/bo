package com.xluo.arithmetic.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * [数据流中的中位数]
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值
 * ，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 思路:因为要记录每次输入,因此定义一个全局容器.再加上要进入排序,那么选择ArrayList是个不错的选择.
 * @author luozhangjie
 *
 */
public class MidNumInStream {

	private static ArrayList<Integer> data = new ArrayList<Integer>();

	public static void Insert(Integer num) {
		data.add(num);
	}

	public static Double GetMedian() {
		Collections.sort(data, new DataComporator());
		if (data.size() % 2 == 0) {
			return (data.get(data.size() / 2 - 1) + data.get(data.size() / 2)) / 2.0;
		} else {
			return data.get(data.size() / 2) / 1.0;
		}
	}

	public static void main(String[] args) {

		int[] datas = new int[] { 1, 3, 1, 5 };
		for (int i = 0; i < datas.length; i++) {
			Insert(datas[i]);
		}
		System.out.println(GetMedian());

	}
}

class DataComporator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
}
