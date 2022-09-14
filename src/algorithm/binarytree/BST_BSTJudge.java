package algorithm.binarytree;

import algorithm.model.TreeNode;

// url:https://leetcode.cn/problems/validate-binary-search-tree/submissions/
public class BST_BSTJudge {

    long pre=Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val<=pre){
            return false;
        }
        pre=root.val;
        return isValidBST(root.right);
    }
}
