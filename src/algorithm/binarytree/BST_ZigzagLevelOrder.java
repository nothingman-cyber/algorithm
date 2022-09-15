package algorithm.binarytree;

import algorithm.model.TreeNode;

import java.util.*;

//url:https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
public class BST_ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        new BST_ZigzagLevelOrder().zigzagLevelOrder(root);
    }

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return res;
        }
        boolean position=true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int[] tmp=new int[queue.size()];
            int ds=queue.size();
            for(int i=0;i<ds;i++){
                TreeNode n;
                n = queue.poll();
                if(n.left!=null){
                    queue.offer(n.left);
                }
                if(n.right!=null){
                    queue.offer(n.right);
                }
                tmp[i]=n.val;
            }
            List<Integer> tmpL=new ArrayList<>(ds);
            if(position){
                for(int i=0;i<ds;i++){
                    tmpL.add(tmp[i]);
                }
            }else{
                for(int i=ds-1;i>=0;i--){
                    tmpL.add(tmp[i]);
                }
            }
            res.add(tmpL);
            position=!position;
        }
        return res;
    }
}
