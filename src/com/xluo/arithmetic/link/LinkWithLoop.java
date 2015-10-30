package com.xluo.arithmetic.link;

/**
 * [链表中环的入口结点]
 * 一个链表中包含环，请找出该链表的环的入口结点
 * 思路:这道题与找链表的倒数第k个结点的做法类似。而现在要找到环的入口,那么如果我能找到
 * 	环有多少个节点,那么就可以把问题转换成找该链表的倒数第k个结点的问题了。
 * @author luozhangjie
 *
 */
public class LinkWithLoop {

	private ListNode findRandomNodeInLoop(ListNode pHead){
		if(pHead == null){
			return null;
		}
		ListNode slow = pHead.next;
		if(slow == null){
			return null;
		}
		ListNode fast = slow.next;
		while(slow != null && fast != null){
			if(slow == fast){
				return fast;
			}
			slow = slow.next;
			fast = fast.next;
			if(fast != null){ //比较slow快
				fast = fast.next;
			}
		}
		return null;
	}
	
	public ListNode EntryNodeOfLoop(ListNode pHead){
		ListNode node = findRandomNodeInLoop(pHead);
		if(node == null){
			return null;
		}
		int nodeInLoop = 1;
		ListNode temp = node;
		while(temp.next != node){
			temp = temp.next;
			++nodeInLoop;
		}
		ListNode fast = pHead;
		for(int i = 0; i < nodeInLoop; i++){
			fast = fast.next;
		}
		ListNode slow = pHead;
		while(fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}

}
