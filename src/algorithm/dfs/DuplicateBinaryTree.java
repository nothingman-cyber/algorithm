package algorithm.dfs;

import algorithm.model.TreeNode;

import java.util.*;

// url:https://leetcode.cn/problems/find-duplicate-subtrees/
public class DuplicateBinaryTree {

    Map<String, TreeNode> record = new HashMap<>();
    Set<TreeNode> res = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(res);
    }

    private String dfs(TreeNode root) {
        String treeText="";
        if(root==null){
            return "";
        }
        treeText+=Integer.toString(root.val);
        treeText+="(";
        treeText+=dfs(root.left);
        treeText+=")";
        treeText+="(";
        treeText+=dfs(root.right);
        treeText+=")";

        if(record.containsKey(treeText)){
            res.add(record.get(treeText));
        }else{
            record.put(treeText,root);
        }
        return treeText;
    }
}
