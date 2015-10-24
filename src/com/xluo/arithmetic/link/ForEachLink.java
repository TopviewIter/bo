package com.xluo.arithmetic.link;

import java.util.ArrayList;
import java.util.Stack;

/**
 * [从尾到头打印链表]
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * @author luozhangjie
 *
 */
public class ForEachLink {
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
        if(listNode == null){
            return tmp;
        }
        tmp.add(listNode.val);
        while(listNode.next != null){
        	tmp.add(listNode.next.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = tmp.size() - 1; i >= 0; i--){
        	result.add(tmp.get(i));
        }
        return result;	
    }
	
	//把上一种的方式中的临时集合改成了栈
	public ArrayList<Integer> printListFromTailToHead_02(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(listNode == null){
			return result;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(listNode.val);
		while(listNode.next != null){
			stack.push(listNode.next.val);
			listNode = listNode.next;
		}
		while(stack.size() != 0){
			result.add(stack.pop());
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		for(int i = 1; i < 10; i++){
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		ArrayList<Integer> result = new ForEachLink().printListFromTailToHead(head);
		for(Integer i : result){
			System.out.println(i);
		}
	}
}

class ListNode{
	int val;
	ListNode next;
	
	ListNode(int val){
		this.val = val;
	}
}
