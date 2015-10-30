package com.xluo.arithmetic.tree;

import com.xluo.arithmetic.tree.BuildTree.TreeNode;

/**
 * [对称的二叉树]
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 思路:一开始是想要通过传入父节点来比较它们的子节点,但这样显然是不合理的,因为要比较两个节点的孩子的情况,一共有4个孩子
 * 	那么这4个孩子是否为null、值是否相等,这些情况的判断数量太多了,很容易造成混乱.那么如果直接就比较当前两个节点,再递归比
 * 	较它们的子节点,这样只有两个节点来比较,是否为null,值是否相等这些情况组合也会少很多,所以采用后者的方式
 * @author luozhangjie
 *
 */
public class IsSymmetricalTree {

	public boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot == null){
			return true;
		}
		return checkNode(pRoot.left, pRoot.right);
		
	}

	private boolean checkNode(TreeNode left, TreeNode right) {
		if(left == null && right == null){
			return true;
		}else if(left == null || right == null){
			return false;
		}else if(left.val != right.val){
			return false;
		}else{
			return checkNode(left.left, right.right) && checkNode(left.right, right.left);
		}
	}

}
