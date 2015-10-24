package com.xluo.arithmetic.link;

/**
 * [链表中倒数第k个结点]
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 快慢指针的应用(主要在要求链表只能遍历一次的情况下应用)
 * @author luozhangjie
 *
 */
public class FindKthToTail {

	public static ListNode findKthToTail(ListNode head, int k) {
		
		if(head == null || k == 0){
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		while(--k > 0){
			if(p1.next != null){
				p1 = p1.next;
			}else{
				return null;
			}
		}
		while(p1.next != null){
			p2 = p2.next;
			p1 = p1.next;
		}
		return p2;
		
	}
	
	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		System.out.println(findKthToTail(n1, 1) == null ? "null" : findKthToTail(n1, 1).val);
	}

}


/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};
//注意代码的鲁棒性,判空与非法输入的限制
class Solution {
public:
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
        if(pListHead == NULL || k == 0){
            return NULL;
        }
    	ListNode *p1 = pListHead;
        ListNode *p2 = pListHead;
        while(--k > 0){
            if(p1->next != NULL){
            	p1 = p1->next;    
            }else{
                return NULL;
            }
        }
        while(p1->next != NULL){
            p2 = p2->next;
            p1 = p1->next;
        }
        return p2;
    }
};

*/