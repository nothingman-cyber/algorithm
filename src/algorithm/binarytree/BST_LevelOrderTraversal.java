package algorithm.binarytree;

import algorithm.model.TreeNode;

import java.util.*;

public class BST_LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(4);
        new BST_LevelOrderTraversal().levelOrder(root);
    }
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> l=new ArrayList<>();
            int c=queue.size();
            for(int i=1;i<=c;i++){
                TreeNode n=queue.poll();
                l.add(n.val);
                if(n.left!=null){
                    queue.offer(n.left);
                }
                if(n.right!=null){
                    queue.offer(n.right);
                }
            }
            res.add(l);
        }
        return res;
    }
}
