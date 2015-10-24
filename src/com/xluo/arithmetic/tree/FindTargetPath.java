package com.xluo.arithmetic.tree;

import java.util.ArrayList;
import java.util.Stack;

import com.xluo.arithmetic.tree.ReBuildBinaryTree.TreeNode;

/**
 * [二叉树中和为某一值的路径]
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 思路:实际上就是一个二叉树的遍历,但这里的重点是什么时候判断这条路线是否是合理的(在叶子节点的时候)
 * 	一开始是思考到可能到结点的中间的时候结点的值就已经大于target的值了,那么就没有必要再遍历下去了,
 * 	但我忽略了一点,树的遍历是连续的,而不是分步的,因此无法在遍历到一半的时候从中间返回,然后再挑一个
 * 	合理的分支去遍历。所以应该保持一个路线一直到叶子节点,再判断是不是目标路线,无论是不是都要把这个节点
 * 	从栈中弹出来,因为这个节点的所有路线都已经遍历完了,应该轮到了一下个节点
 * @author luozhangjie
 *
 */
public class FindTargetPath {

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		Stack<Integer> s = new Stack<Integer>();
		findPath(root, target, s, result);
		return result;
	}

	private void findPath(TreeNode node, int target, Stack<Integer> s,
			ArrayList<ArrayList<Integer>> result) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (node.val == target) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				for (Integer i : s) {
					path.add(i);
				}
				path.add(node.val);
				result.add(path);
			}
		} else {
			s.push(node.val);
			findPath(node.left, target - node.val, s, result);
			findPath(node.right, target - node.val, s, result);
			s.pop(); //把已经访问了左右孩子的中间结点出栈
		}
	}

}
