package com.xluo.arithmetic.link;

import java.util.Stack;

/**
 * [两个链表的第一个公共结点]
 * 输入两个链表，找出它们的第一个公共结点。
 * 思路:最直接的方式就是用第一个链表的每个节点去匹配第二个链表中的所有节点。但这种蛮力法的时间复杂度为O(nm)
 * 	第二种思路是,因为是单向链表,那么链表的节点的next只能有一个,那么说明,两个链表如果有相交,那么它们的形状是Y形
 * 	而不会是X形。那么如果借助栈,则可以把时间复杂度降到O(n + m)
 * 	第三种思路是,先让长的链表先走,然后等到大家的长度相同了,再一起走(因为是Y形,所以先走的部分不会包含公共节点)
 * @author luozhangjie
 *
 */
public class FindCommonNode {

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		while (p1 != null && p2 != null) {
			ListNode temp = p1;
			while (temp != null) {
				if (temp == p2) {
					return temp;
				}
				temp = temp.next;
			}
			p2 = p2.next;
		}
		return null;
	}
	
	public ListNode FindFirstCommonNode_01(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null){
			return null;
		}
		Stack<ListNode> p1 = new Stack<ListNode>();
		Stack<ListNode> p2 = new Stack<ListNode>();
		ListNode h1 = pHead1;
		ListNode h2 = pHead2;
		while(h1 != null || h2 != null){ //入栈操作O(n)
			if(h1 != null){
				p1.push(h1);
				h1 = h1.next;
			}
			if(h2 != null){
				p2.push(h2);
				h2 = h2.next;
			}
		}
		ListNode pre = null;
		while(p1.size() != 0 && p2.size() != 0){ //寻找相同节点O(m)
			ListNode t1 = p1.pop();
			ListNode t2 = p2.pop();
			if(t1 == t2){
				pre = t1;
			}else{
				break;
			}
		}
		return pre;
	}
	
	public ListNode FindFirstCommonNode_02(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null){
			return null;
		}
		int h1Length = linkLength(pHead1);
		int h2Length = linkLength(pHead2);
		int length = h1Length - h2Length;
		ListNode l = pHead1;
		ListNode s = pHead2;
		if(length < 0){
			length = h2Length - h1Length;
			l = pHead2;
			s = pHead1;
		}
		for(int i = 0; i < length; i++){
			l = l.next;
		}
		while(l != null && s != null){
			if(l == s){
				return l;
			}
			l = l.next;
			s = s.next;
		}
		return null;
		
	}
	
	private int linkLength(ListNode n){ //查询长度O(n)
		int length = 0;
		ListNode node = n;
		while(node != null){
			length++;
			node = node.next;
		}
		return length;
	}

}
