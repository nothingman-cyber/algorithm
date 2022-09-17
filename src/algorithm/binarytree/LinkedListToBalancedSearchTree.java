package algorithm.binarytree;

import algorithm.model.ListNode;
import algorithm.model.TreeNode;

// url:https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/
public class LinkedListToBalancedSearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        return build(head,null);
    }

    private TreeNode build(ListNode left,ListNode right) {
        if(left==right){
            return null;
        }
        ListNode mid=findMid(left,right);
        TreeNode root=new TreeNode(mid.val);
        root.left=build(left,mid);
        root.right=build(mid.next,right);
        return root;
    }

    private ListNode findMid(ListNode left,ListNode right) {
        ListNode slow=left;
        ListNode quick=left;
        while(quick!=right&&quick.next!=right){
            slow=slow.next;
            quick=quick.next;
            quick=quick.next;
        }
        return slow;
    }
}
