package algorithm.binarytree;

import algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// url:https://leetcode.cn/problems/sum-root-to-leaf-numbers/
public class Root_Leave_Val_Sum {

    public static void main(String[] args) {
        int a=19,b=1;
        // 10011
        // 00001
        // 10010
        // 00010
        System.out.print(a^b);
    }

    int res=0;

    public int sumNumbers(TreeNode root) {
        List<Integer> tmp=new ArrayList<>();
        dfs(root,tmp);
        return res;
    }

    private void dfs(TreeNode root,List<Integer> tmp) {
        tmp.add(root.val);
        if(root.left!=null){
            dfs(root.left,tmp);
        }
        if(root.right!=null){
            dfs(root.right,tmp);
        }
        if(root.left==null&&root.right==null) {
            int tmpInt = 0;
            for (Integer i : tmp) {
                tmpInt = tmpInt * 10 + i;
            }
            res += tmpInt;
        }
        tmp.remove(tmp.size()-1);
    }
}
