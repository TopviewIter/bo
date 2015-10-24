package com.xluo.arithmetic.tree;

/**
 * [二叉搜索树的后序遍历序列]
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路:因为是后序遍历,说明序列的最后一个是根,那么对于二叉树要满足的条件是,左子树的值都要小于根,
 * 	右子树的值都要大于根,根据这个特点,对子树进行递归判断
 * @author luozhangjie
 *
 */
public class LastVisitTreeArray {

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}
		int root = sequence[sequence.length - 1];
		int rootIndexNum = rootIndex(sequence, root);
		int[] pre = new int[rootIndexNum];
		int[] next = new int[sequence.length - rootIndexNum - 1];//要减掉最后那个根
		for (int i = 0, j = 0; i < sequence.length - 1; i++) {
			if (i < rootIndexNum) {
				if (sequence[i] > root) {
					return false;
				}
				pre[i] = sequence[i];
			} else {
				if (sequence[i] < root) {
					return false;
				}
				next[j++] = sequence[i];
			}
		}
		VerifySquenceOfBST(pre);
		VerifySquenceOfBST(next);
		return true;
	};

	//这里返回的值就是左孩子的数组长度
	private int rootIndex(int[] array, int root) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > root) {
				return i;
			}
		}
		return array.length - 1;
	}

}
