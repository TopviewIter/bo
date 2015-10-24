package com.xluo.arithmetic.tree;

/**
 * [编程题]重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：递归,先是从整棵树来思考,给出先序、中序,怎么确定根节点与它的左右孩子(从先序可找到根节点、
 * 	中序可以找到左右子树,再从先序找相同长度的值就可以得到左右子树的先序序列,从而确定左右子树的根节点)
 * 	那么左右子树的根节点的孩子又如何确定,原理与整棵树一样,只不过先序与中序序列发生了改变,所以可以用递归)
 * @author luozhangjie
 *
 */
public class ReBuildBinaryTree {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		//左孩子中序序列
		int[] leftTreeIn = getLeftTreeIn(in, pre[0]);
		//右孩子中序序列
		int[] rightTreeIn = getRightTreeIn(in, pre[0]);
		//左孩子先序序列
		int[] leftTreePre = getLeftTreePre(pre, leftTreeIn.length);
		//右孩子先序序列
		int[] rightTreePre = getRightTreePre(pre, rightTreeIn.length);
		root.left = reConstructBinaryTree(leftTreePre, leftTreeIn);
		root.right = reConstructBinaryTree(rightTreePre, rightTreeIn);
		return root;
	}

	private int[] getLeftTreePre(int[] pre, int length) {
		int[] temp = new int[length];
		for (int i = 1; i < length + 1 && length != 0; i++) {
			temp[i - 1] = pre[i];
		}
		return temp;
	}

	private int[] getRightTreePre(int[] pre, int length) {
		int[] temp = new int[length];
		for (int i = pre.length - length, j = 0; i < pre.length && length != 0; i++) {
			temp[j++] = pre[i];
		}
		return temp;
	}

	private int[] getLeftTreeIn(int[] in, int root) {
		int[] temp = new int[rootIndexInIn(in, root)];
		for (int i = 0; i < in.length && temp.length != 0; i++) {
			if (in[i] != root) {
				temp[i] = in[i];
			} else {
				break;
			}
		}
		return temp;
	}

	private int[] getRightTreeIn(int[] in, int root) {
		//in.length - 1:最后一个元素的下标,in.length - 1 - rootIndexInIn(in, root):节点个数
		int[] temp = new int[in.length - 1 - rootIndexInIn(in, root)];
		boolean sign = false;
		for (int i = 0, j = 0; i < in.length && temp.length != 0; i++) {
			if (in[i] == root) { //in[i++] == root这种写法错误,这样每次判断都会+1
				sign = true;
				i++;
			}
			if (sign) {
				temp[j++] = in[i];
			}
		}
		return temp;
	}

	private int rootIndexInIn(int[] in, int root) {
		for (int i = 0; i < in.length; i++) {
			if (in[i] == root) {
				return i;
			}
		}
		return -1;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		new ReBuildBinaryTree().reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
	}
}
