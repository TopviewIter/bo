package com.xluo.arithmetic.tree;

import com.xluo.arithmetic.tree.ReBuildBinaryTree.TreeNode;

/**
 * [树的子结构]
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 * 思路:先判断根是否相等,不等则用左右子树进行递归。
 * 	当根相等时,那么就用子树进行递归判断
 * @author luozhangjie
 *
 */
public class HasSubtree {
	
	public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
		
		boolean result = false;
		
		if(root1 != null && root2 != null){
			if(root1.val == root2.val){
				result = isHasSubtree(root1, root2);
			}
			if(!result){
				result = hasSubtree(root1.left, root2);
			}
			if(!result){
				result = hasSubtree(root1.right, root2);
			}
		}
		
		return result;
	}
	
	private static boolean isHasSubtree(TreeNode root1, TreeNode root2){
		
		if(root2 == null){
			return true;
		}else if(root1 == null){
			return false;
		}
		
		if(root1.val != root2.val){
			return false;
		}
		
		return isHasSubtree(root1.left, root2.left) && isHasSubtree(root1.right, root2.right);
	}
	
}

/*---------------------------------------------------------------------------------------

struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};
class Solution {
public:
    bool HasSubtree(TreeNode* pRoot1, TreeNode* pRoot2)
    {
		bool result = false;
        if(pRoot1 != NULL && pRoot2 != NULL){
            if(pRoot1->val == pRoot2->val){
                result = isSubtree(pRoot1, pRoot2);
            }
            if(!result){
                result = HasSubtree(pRoot1->left, pRoot2);
            }
            if(!result){
                result = HasSubtree(pRoot1->right, pRoot2);
            }
        }
        return result;
    }
    
    bool isSubtree(TreeNode* pRoot1, TreeNode* pRoot2){
        if(pRoot2 == NULL){
            return true;
        }
        if(pRoot1 == NULL){
            return false;
        }
        if(pRoot1->val != pRoot2->val){
            return false;
        }
        return isSubtree(pRoot1->left, pRoot2->left) && isSubtree(pRoot1->right, pRoot2->right);
    }
};
 */
