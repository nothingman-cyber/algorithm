package algorithm.dfs;

import algorithm.model.TreeNode;

// https://leetcode.cn/problems/longest-univalue-path/
public class LongestEquivalencePath {

    public int longestUnivaluePath(TreeNode root) {
        res=0;
        dfs(root);
        return res;
    }

    int res;

    private int dfs(TreeNode r){
        if(r==null)return 0;
        int left=dfs(r.left);
        int right=dfs(r.right);
        int leftWithThisLayer=0;
        int rightWithThisLayer=0;
        if(r.left!=null&&r.left.val==r.val){
            leftWithThisLayer=left+1;
        }
        if(r.right!=null&&r.right.val==r.val){
            rightWithThisLayer=right+1;
        }
        res=Math.max(res,leftWithThisLayer+rightWithThisLayer);
        return Math.max(leftWithThisLayer,rightWithThisLayer);
    }
}
