package com.xluo.arithmetic.link;

/**
 * [合并两个排序的链表] 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 思路:当看到这个题目的时候，第一个想到的就是很像归并排序，然后，采用了归并排序的思路来做。
 * 但代码冗余度有点高。。实际上可以把那四个if-else块封装成一个方法来用
 * @author luozhangjie
 *
 */
public class MergeTwoSortedLink {

	public static ListNode merge(ListNode list1, ListNode list2) {

		ListNode newLink = null;
		ListNode newLinkHead = null;
		ListNode p1 = list1;
		ListNode p2 = list2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				if (newLink == null) {
					newLink = p1;
					newLinkHead = p1;
				} else {
					newLink.next = p1;
					newLink = newLink.next;
				}
				p1 = p1.next;
			} else {
				if (newLink == null) {
					newLink = p2;
					newLinkHead = p2;
				} else {
					newLink.next = p2;
					newLink = newLink.next;
				}
				p2 = p2.next;
			}
		}
		while (p1 != null) {
			if (newLink == null) {
				newLink = p1;
				newLinkHead = p1;
			} else {
				newLink.next = p1;
				newLink = newLink.next;
			}
			p1 = p1.next;
		}
		while (p2 != null) {
			if (newLink == null) {
				newLink = p2;
				newLinkHead = p2;
			} else {
				newLink.next = p2;
				newLink = newLink.next;
			}
			p2 = p2.next;
		}
		return newLinkHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(5);
		n4.next = n5;
		n5.next = n6;
		ListNode result = merge(n1, n4);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}

/*-----------------------------------------------------------------------------------
 /*
 struct ListNode {
 int val;
 struct ListNode *next;
 ListNode(int x) :
 val(x), next(NULL) {
 }
 };
 class Solution {
 public:
 ListNode* Merge(ListNode* pHead1, ListNode* pHead2)
 {
 ListNode* newLink = NULL;
 ListNode* newLinkHead = NULL;
 ListNode* p1 = pHead1;
 ListNode* p2 = pHead2;
 while(p1 && p2){ //two link all not at end
 if(p1->val < p2->val){
 if(newLink){
 newLink->next = p1;
 newLink = newLink->next;
 }else{
 newLink = p1;
 newLinkHead = p1;
 }
 p1 = p1->next;
 }else{
 if(newLink){
 newLink->next = p2;
 newLink = newLink->next;
 }else{
 newLink = p2;
 newLinkHead = p2;
 }
 p2 = p2->next;
 }
 }
 while(p1){ //p1 leave some node
 if(newLink){
 newLink->next = p1;
 newLink = newLink->next;
 }else{
 newLink = p1;
 newLinkHead = p1;
 }
 p1 = p1->next;
 }
 while(p2){ //p2 leave some node
 if(newLink){
 newLink->next = p2;
 newLink = newLink->next;
 }else{
 newLink = p2;
 newLinkHead = p2;
 }
 p2 = p2->next;
 }
 return newLinkHead;
 }
 };
 */