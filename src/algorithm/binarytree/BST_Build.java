package algorithm.binarytree;

import algorithm.model.TreeNode;

// url:https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
public class BST_Build {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return genBST(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode genBST(int[] preorder, int pre_start, int pre_end,
                            int[] inorder, int in_start, int in_end){

        if(in_start==in_end){
            return new TreeNode(inorder[in_start]);
        }else if(in_start>in_end){
            return null;
        }

        int rootVal=preorder[pre_start];
        int rootIdx=-1;
        for(int i=in_start;i<=in_end;i++){
            if(inorder[i]==rootVal){
                rootIdx=i;
            }
        }
        int x=rootIdx-in_start;
        int y=in_end-rootIdx;
        TreeNode root=new TreeNode(rootVal);
        root.left=genBST(preorder,pre_start+1,pre_start+x,inorder,in_start,in_start+x-1);
        root.right=genBST(preorder,pre_start+x+1,pre_start+x+y,inorder,rootIdx+1,rootIdx+y);
        return root;
    }
}
