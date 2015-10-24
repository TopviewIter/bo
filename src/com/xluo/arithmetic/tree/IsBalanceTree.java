package com.xluo.arithmetic.tree;

import com.xluo.arithmetic.tree.ReBuildBinaryTree.TreeNode;

/**
 * [平衡二叉树]
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 思路:实际上就是一个求树的高度的问题,但要清楚平衡二叉树的定义:它是一个空树或左右子树都是平衡二叉树
 * @author luozhangjie
 *
 */
public class IsBalanceTree {

	private int getDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
	}
	
	public boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		int diff = leftDepth - rightDepth;
		if(diff > 1 || diff < -1){
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
}
