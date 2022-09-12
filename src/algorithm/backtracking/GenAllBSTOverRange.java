package algorithm.backtracking;

import algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// url:https://leetcode.cn/problems/unique-binary-search-trees-ii/
public class GenAllBSTOverRange {

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<>();
        }
        return backTracking(1,n);
    }

    public List<TreeNode> backTracking(int start,int end) {
        List<TreeNode> collection=new ArrayList<>();
        if(start>end){
            collection.add(null); // 这句代码立大功
            return collection;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftCollection=backTracking(start,i-1);
            List<TreeNode> rightCollection=backTracking(i+1,end);
            for(TreeNode left:leftCollection){
                for(TreeNode right:rightCollection){
                    TreeNode cntNode=new TreeNode(i);
                    cntNode.left=left;
                    cntNode.right=right;
                    collection.add(cntNode);
                }
            }
        }
        return collection;
    }
}
