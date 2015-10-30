package com.xluo.arithmetic.link;

/**
 * [删除链表中重复的结点] 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * @author luozhangjie
 *
 */
public class DeleteRepeatNode {

	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return pHead;
		}
		ListNode temp = pHead;
		ListNode pre = null;
		boolean flag = false;
		while (temp != null && temp.next != null) {
			while (temp.next != null && temp.val == temp.next.val) {
				ListNode node = temp;
				pre = temp.next;
				temp = node.next;
				node.next = null;
				flag = true;
			}
			if (flag) {
				ListNode node = temp;
				pre = temp.next;
				temp = node.next;
				node.next = null;
			}
			if (temp != null && temp.next != null && temp.val != temp.next.val) {
				break;
			}
		}
		pHead = temp;
		while (temp != null && temp.next != null) {
			if (temp.next != null && temp.val != temp.next.val) {
				pre = temp;
				temp = temp.next;
			}
			boolean sign = false;
			while (temp.next != null && temp.val == temp.next.val) {
				ListNode node = temp.next;
				temp.next = node.next;
				node.next = null;
				sign = true;
			}
			if (sign) {
				ListNode node = temp;
				temp = node.next;
				pre.next = temp;
				node.next = null;
			}
		}
		return pHead;
	}

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(1);
		ListNode l6 = new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		ListNode head = deleteDuplication(l1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
