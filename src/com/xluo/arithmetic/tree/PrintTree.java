package com.xluo.arithmetic.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * [按之字形顺序打印二叉树]
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路:使用两个栈轮流切换遍历实现之字打印,利用了栈后进先出的特点
 * @author luozhangjie
 *
 */
public class PrintTree {

	private static TreeNode root;

	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> child = new Stack<TreeNode>();
		s.push(pRoot);
		while (true) {
			if (s.isEmpty()) {
				break;
			}
			ArrayList<Integer> r = new ArrayList<Integer>();
			while (!s.isEmpty()) {
				TreeNode node = s.pop();
				r.add(node.val);
				if (node.left != null) {
					child.push(node.left);
				}
				if (node.right != null) {
					child.push(node.right);
				}
			}
			result.add(r);
			if (child.isEmpty()) {
				break;
			}
			ArrayList<Integer> c = new ArrayList<Integer>();
			while (!child.isEmpty()) {
				TreeNode node = child.pop();
				c.add(node.val);
				if (node.right != null) {
					s.push(node.right);
				}
				if (node.left != null) {
					s.push(node.left);
				}
			}
			result.add(c);
		}
		return result;
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
		ArrayList<ArrayList<Integer>> result = Print(root);
		if (result.size() != 0) {
			for (ArrayList<Integer> r : result) {
				if (r != null && r.size() != 0) {
					for (Integer integer : r) {
						System.out.print(integer + " ");
					}
					System.out.println();
				}
			}
		}

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
