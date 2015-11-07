package com.xluo.arithmetic.tree;

import com.xluo.arithmetic.tree.BuildTree.TreeNode;

/**
 * [序列化二叉树]
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 思路:这里要求用的是先序遍历,在反序列化的时候,实际上与先序遍历一样,先设置好了所有的左孩子再去设置右孩子
 * @author luozhangjie
 *
 */
public class SerializeTree {

	static int index = -1;//字符串角标索引
	
	public static String Serialize(TreeNode root) {
		String result = "";
		if (root == null) {
			result += "#,";
			return result;
		}
		result += root.val + ",";
		result += Serialize(root.left);
		result += Serialize(root.right);
		return result;
	}

	public static TreeNode Deserialize(String str) {
		index++;
		String[] strArr = str.split(",");
		if (index >= strArr.length)
			return null;
		TreeNode tNode = null;
		if (!strArr[index].equals("#")) {
			tNode = new TreeNode(Integer.parseInt(strArr[index]));
			tNode.left = Deserialize(str);
			tNode.right = Deserialize(str);
		}
		return tNode;
	}

}
