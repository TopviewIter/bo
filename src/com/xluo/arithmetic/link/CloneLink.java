package com.xluo.arithmetic.link;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * [复杂链表的复制]
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 思路:一开始想要用递归,先连上next再连上random,类似于树的递归遍历,但忽略了一个问题就是:random可以是
 * 	这个节点的前面也可以是这个节点的后面.那么next与random的操作只能分步进行了,但如何保存两个链表间的节点
 * 	的对应关系?开始没想到...有考虑用hashmap,但觉得不应该用到这么复杂的容器吧,后来才发现真的如此
 * @author luozhangjie
 *
 */
public class CloneLink {

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode result = new RandomListNode(-1);
		RandomListNode p = pHead;
		while (p != null) {
			RandomListNode temp = new RandomListNode(p.label);
			map.put(p, temp);
			result.next = temp;
			result = result.next;
			p = p.next;
		}
		Set<Entry<RandomListNode, RandomListNode>> set = map.entrySet();
		for (Iterator<Entry<RandomListNode, RandomListNode>> iter = set.iterator(); iter
				.hasNext();) {
			Entry<RandomListNode, RandomListNode> entry = iter.next();
			entry.getValue().random = entry.getKey().random;
		}
		return map.get(p);
	}

	class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

}
