package com.xluo.arithmetic.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * [把二叉树打印成多行]
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 思路:层次遍历的变形,主要是控制当前行要打印多个次,下一行要打印多少次
 * @author luozhangjie
 *
 */
public class PrintAsLine {

	private static TreeNode root;
	
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null){
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(pRoot);
		int size = 1;
		while(true){
			ArrayList<Integer> r = new ArrayList<Integer>();
			int next = 0;
			while(!queue.isEmpty()){
				TreeNode node = queue.pop();
				if(size-- != 0){
					r.add(node.val);
				}
				if(node.left != null){
					queue.offer(node.left);
					next++;
				}
				if(node.right != null){
					queue.offer(node.right);
					next++;
				}
				if(size == 0){
					break;
				}
			}
			result.add(r);
			size = next;
			if(queue.isEmpty()){
				break;
			}
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

//		int[] data = new int[] { 8, 6, 10, 5, 7, 9, 11 };
		int[] data = new int[] { 5, 4, 3, 2};
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
