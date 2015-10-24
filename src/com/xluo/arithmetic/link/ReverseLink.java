package com.xluo.arithmetic.link;

/**
 * [反转链表] 输入一个链表，反转链表后，输出链表的所有元素。 思路:采用头插法
 * 每次从原链表断开一个节点(因此要有一个变量,记住这个节点的后驱),使这个节点插入到新链表的头 (因此要有一个变量,记住这个新链表的头)
 * 
 * @author luozhangjie
 *
 */
public class ReverseLink {

	public ListNode ReverseList(ListNode head) {
		
		ListNode newLink = null; //new link head
		ListNode changePoint = head; //the node need to remove
		while (changePoint != null) { //remove each node
			ListNode temp = changePoint.next; //remember the next node
			changePoint.next = newLink; //concat to new link
			newLink = changePoint; //return head
			changePoint = temp; //remove the next node
		}
		return newLink;
		
	}

}
