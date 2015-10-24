package com.xluo.arithmetic.tree;

import com.xluo.arithmetic.tree.ReBuildBinaryTree.TreeNode;

/**
 * [二叉树的深度] 
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路:通过递归的方式来求
 * @author luozhangjie
 *
 */
public class TreeDepth {

	public int treeDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int leftDepth = treeDepth(root.left);
		int rightDepth = treeDepth(root.right);
		int result = leftDepth > rightDepth ? leftDepth : rightDepth;
		return result + 1;

	}

}
