package com.xluo.arithmetic.tree;

import java.util.Stack;

/**
 * [二叉树的下一个结点]
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 思路:
 * 方法一:这里实际上就是中序遍历的考查,只是做了一个简单的变形,只要找到它的根节点即可使用中序遍历
 * 方法二:
 * @author luozhangjie
 *
 */
public class GetNext {

	private static TreeLinkNode root;
	
	public static TreeLinkNode getNextMoreEasy(TreeLinkNode pNode){
		if(pNode == null){
			return pNode;
		}
		if(pNode.right != null){
			TreeLinkNode node = pNode.right;
			while(node.left != null){
				node = node.left;
			}
			return node;
		}else{
			while(pNode.next != null && pNode.next.left != pNode){ //pNode是右孩子的时候
				pNode = pNode.next;
			}
			return pNode.next;
		}
	}
	
	public static TreeLinkNode getNext(TreeLinkNode pNode) {
		if(pNode == null){
			return pNode;
		}
		TreeLinkNode root = getRoot(pNode);
		TreeLinkNode node = root;
		Stack<TreeLinkNode> s = new Stack<TreeLinkNode>();
		boolean sign = false;
		while(node != null || s.size() != 0){
			while(node != null){
				s.push(node);
				node = node.left;
			}
			if(s.size() > 0){
				node = s.pop();
				if(sign){
					return node;
				}
				if(node.val == pNode.val){
					sign = true;
				}
				node = node.right;
			}
		}
		return null;
	}
	
	private static TreeLinkNode getRoot(TreeLinkNode pNode){
		TreeLinkNode node = pNode;
		while(node.next != null){
			node = node.next;
		}
		return node;
	}
	
	private static void buildTree(TreeLinkNode node, int data){
		if(root == null){
			root = new TreeLinkNode(data);
		}else{
			if(data > node.val){
				if(node.right == null){
					node.right = new TreeLinkNode(data);
					node.right.next = node;
				}else{
					buildTree(node.right, data);
				}
			}else if(data < node.val){
				if(node.left == null){
					node.left = new TreeLinkNode(data);
					node.left.next = node;
				}else{
					buildTree(node.left, data);
				}
			}
		}
	}
	
	private static TreeLinkNode getNode(int data){
		TreeLinkNode node = root;
		Stack<TreeLinkNode> s = new Stack<TreeLinkNode>();
		while(node != null || s.size() > 0){
			while(node != null){
				s.push(node);
				node = node.left;
			}
			if(s.size() > 0){
				node = s.pop();
				if(node.val == data){
					return node;
				}
				node = node.right;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		int[] data = new int[]{8, 6, 10, 5, 7, 9, 11};
		for(int i = 0; i < data.length; i++){
			buildTree(root, data[i]);
		}
		
		System.out.println(getNext(getNode(8)).val);
		System.out.println(getNextMoreEasy(getNode(8)).val);
		
	}
	
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
