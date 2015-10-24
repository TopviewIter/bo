package com.xluo.arithmetic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.xluo.arithmetic.tree.ReBuildBinaryTree.TreeNode;

/**
 * [从上往下打印二叉树]
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路:实际上就是对层次遍历的一个考查
 * @author luozhangjie
 *
 */
public class LevelVisitTree {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(queue.size() != 0){
			TreeNode node = queue.poll();
			list.add(node.val);
			if(node.left != null){
				queue.offer(node.left);
			}
			if(node.right != null){
				queue.offer(node.right);
			}
		}
		return list; 
	}

}
