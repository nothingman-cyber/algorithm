package algorithm.binarytree;

import algorithm.model.TreeNode;

// url:https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
public class BST_Build_2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] postorder, int ps, int pe, int[] inorder, int is, int ie){

        if(is==ie){
            return new TreeNode(inorder[is]);
        }else if(is>ie){
            return null;
        }

        int rootVal=postorder[pe];
        int rootPos=-1;
        for(int i=is;i<=ie;i++){
            if(inorder[i]==rootVal){
                rootPos=i;
            }
        }
        int leftLen=rootPos-is;
        int rightLen=ie-rootPos;
        TreeNode root=new TreeNode(rootVal);
        root.left=build(postorder,ps,ps+leftLen-1,inorder,is,is+leftLen-1);
        root.right=build(postorder,ps+leftLen,ps+leftLen+rightLen-1,inorder,rootPos+1,rootPos+rightLen);
        return root;
    }
}
