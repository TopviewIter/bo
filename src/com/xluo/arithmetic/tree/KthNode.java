package com.xluo.arithmetic.tree;

import java.util.Stack;

/**
 * [二叉搜索树的第k个结点]
 * 找出有序序列中的第k个结点
 * 思路:实际上就是对中序遍历的一个考查,因为中序遍历出来的结果是有序的,那么就可以把k当作
 * 	一个计数器,从而很方便地得到第k个数,这里要注意,不能在进栈的时候进行计数,因为那只是第
 * 	k个进栈的,而不是出栈的
 * @author luozhangjie
 *
 */
public class KthNode {
	
	private static TreeNode root;

	public static TreeNode kthNode(TreeNode pRoot, int k) {
		TreeNode node = pRoot;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(!s.isEmpty() || node != null){
			while(node != null){
				s.push(node);
				node = node.left;
			}
			if(!s.isEmpty()){
				node = s.pop();
				if(--k == 0){
					return node;
				}
				node = node.right;
			}
		}
		return null;
	}
	
	private static void buildTree(TreeNode node, int data) {
		if (root == null) {
			root = new TreeNode(data);
		} else {
			if (data > node.val) {
				if (node.right == null) {
					node.right = new TreeNode(data);
				} else {
					buildTree(node.right, data);
				}
			} else if (data < node.val) {
				if (node.left == null) {
					node.left = new TreeNode(data);
				} else {
					buildTree(node.left, data);
				}
			}
		}
	}

	public static void main(String[] args) {

		int[] data = new int[] { 8, 6, 10, 5, 7, 9, 11 };
		for (int i = 0; i < data.length; i++) {
			buildTree(root, data[i]);
		}
		System.out.println(kthNode(root, 1).val);

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
