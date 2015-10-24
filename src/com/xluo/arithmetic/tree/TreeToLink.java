package com.xluo.arithmetic.tree;

import java.util.Stack;

/**
 * [二叉搜索树与双向链表]
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author luozhangjie
 *
 */
public class TreeToLink {

	private static TreeNode root;
	
	public static void buildTree(TreeNode node, int data){
		if(root == null){
			root = new TreeNode(data);
		}else{
			if(data < node.val){
				if(node.left == null){
					node.left = new TreeNode(data);
				}else{
					buildTree(node.left, data);
				}
			}else{
				if(node.right == null){
					node.right = new TreeNode(data);
				}else{
					buildTree(node.right, data);
				}
			}
		}
	}
	
	public static TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode node = pRootOfTree;
		TreeNode pre = null;
		while (node != null || s.size() != 0) {
			while (node != null) {
				s.push(node);
				node = node.left;
			}
			if (s.size() != 0) {
				node = s.pop();
				TreeNode right = node.right;
				node.left = null;
				node.right = null;
				if(pre == null){
					pRootOfTree = node;
				}else{
					node.left = pre;
					pre.right = node;
				}
				pre = node;
				node = right;
			}
		}
		return pRootOfTree;
	}

	public static void main(String[] args) {
		int[] root1 = new int[] {10, 6, 14, 4, 8, 12, 16};
		for (int i = 0; i < root1.length; i++) {
			buildTree(root, root1[i]);
		}
		TreeNode node = Convert(root);
		TreeNode temp = null;
		while(node != null){
			System.out.println(node.val);
			temp = node;
			node = node.right;
		}
		while(temp != null){
			System.out.println(temp.val);
			temp = temp.left;
		}
		
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
