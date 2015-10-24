package com.xluo.arithmetic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * [创建二叉查找树] 思路:从外面传进根节点(这个节点有递归的时候是子树的根节点),那么根(整棵树的根,它是一个全局变量)先判断是否为null
 * 如果为null,则创建该节点,如果不是则说明这个节点是属于子树的,那么通过判断值是属于
 * 左子树还是右子树,再判断左右子树的根是否为空,如果是则创建,如果不是则进行递归
 * 
 * @author luozhangjie
 *
 */
public class BuildTree {

	private static TreeNode t;

	// build tree
	private static void buildTree(TreeNode node, int data) {

		if (t == null) { // build root node
			t = new TreeNode(data);
		} else { // build child node
			if (data < node.val) {
				if (node.left == null) {
					node.left = new TreeNode(data);
				} else {
					buildTree(node.left, data);
				}
			} else {
				if (node.right == null) {
					node.right = new TreeNode(data);
				} else {
					buildTree(node.right, data);
				}
			}
		}

	}

	// 先序遍历
	private static void preVisitTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preVisitTree(root.left);
		preVisitTree(root.right);
	}

	/**
	 * 非递归先序遍历 思路:借助栈,先让要访问的节点进栈,出栈访问后,再让它的孩子进栈,再进行访问(递归都可以用循环替代) 相当于保存了未遍历的子树的根
	 * 
	 * @param root
	 */
	private static void preVisitTree_02(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.empty()) {
			root = s.pop();
			System.out.print(root.val + " ");
			// 由于栈的先进后出的特点,要让右孩子先进栈,再让左孩子进栈
			if (root.right != null) {
				s.push(root.right);
			}
			if (root.left != null) {
				s.push(root.left);
			}
		}
	}

	/**
	 * 借助栈,让左孩子先入栈,因为是先序,所以在进栈前就进行访问,再能过把左孩子出栈 得到它的右孩子,再到以右孩子为根节点的子树进行相应的操作
	 * 
	 * @param root
	 */
	private static void preVisitTree_03(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode node = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (node != null || s.size() != 0) {
			while (node != null) {
				System.out.print(node.val + " ");
				s.push(node);
				node = node.left;
			}
			if (s.size() > 0) {
				node = s.pop();
				node = node.right;
			}
		}
	}

	// 中序遍历
	private static void midVisitTree(TreeNode root) {
		if (root == null) {
			return;
		}
		midVisitTree(root.left);
		System.out.print(root.val + " ");
		midVisitTree(root.right);
	}

	/**
	 * 借助栈,让左孩子先入栈,因为是中序,所以在出栈进才进行访问, 然后得到它的右孩子,再到以右孩子为根节点的子树进行相应的操作
	 * 
	 * @param root
	 */
	private static void midVistiTree_02(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode node = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (node != null || s.size() > 0) {
			while (node != null) {
				s.push(node);
				node = node.left;
			}
			if (s.size() > 0) {
				node = s.pop();
				System.out.print(node.val + " ");
				node = node.right;
			}
		}
	}

	// 后序遍历
	private static void lastVisitTree(TreeNode root) {
		if (root == null) {
			return;
		}
		lastVisitTree(root.left);
		lastVisitTree(root.right);
		System.out.print(root.val + " ");
	}

	public static void lastVisitTree_02(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root, prev = root; // prev记住前一个被访问的值
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {
				TreeNode temp = stack.peek().right;
				// 对于一个节点,它的右孩子如果不为空那么就是前一个被访问的值
				if (temp == null || temp == prev) {
					node = stack.pop();
					System.out.print(node.val + " ");
					prev = node;
					node = null;
				} else {
					// 当右孩子没有被访问过的时候,把它及它的子树都放到栈中
					node = temp;
				}
			}

		}
	}

	// 层次遍历
	public static void levelVisitTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.offer(root);
		}
		while (queue.size() > 0) {
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

	public static void main(String[] args) {
		int[] root1 = new int[] { 1, 4, 3, 6, 5 };
		for (int i = 0; i < root1.length; i++) {
			buildTree(t, root1[i]);
		}
		System.out.println("先序遍历");
		preVisitTree(t);
		System.out.println();
		preVisitTree_02(t);
		System.out.println();
		preVisitTree_03(t);
		System.out.println();

		System.out.println("中序遍历");
		midVisitTree(t);
		System.out.println();
		midVistiTree_02(t);
		System.out.println();

		System.out.println("后序遍历");
		lastVisitTree(t);
		System.out.println();
		lastVisitTree_02(t);
		System.out.println();

		System.out.println("层次遍历");
		levelVisitTree(t);
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
