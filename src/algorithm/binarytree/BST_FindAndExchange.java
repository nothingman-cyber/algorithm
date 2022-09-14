package algorithm.binarytree;

import algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BST_FindAndExchange {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        new BST_FindAndExchange().ergodic(root);
        int i=1;
    }

    TreeNode[] exchange=new TreeNode[2];
    List<TreeNode> tNodes=new ArrayList<>();

    public void recoverTree(TreeNode root) {
        ergodic(root);
        // 1 4 3 2 5
        // 2 1 3
        for(int i=0;i<tNodes.size();i++){
            if(tNodes.get(i).val>tNodes.get(i+1).val){
                exchange[0]=tNodes.get(i);
                break;
            }
        }

        for(int i=tNodes.size()-1;i>0;i--){
            if(tNodes.get(i).val<tNodes.get(i-1).val){
                exchange[1]=tNodes.get(i);
                break;
            }
        }

        int tmp=exchange[0].val;
        exchange[0].val=exchange[1].val;
        exchange[1].val=tmp;
    }

    private void ergodic(TreeNode root){
        if(root==null){
            return;
        }

        ergodic(root.left);

        tNodes.add(root);

        ergodic(root.right);
    }
}
