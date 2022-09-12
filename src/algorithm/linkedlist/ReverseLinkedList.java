package algorithm.linkedlist;

import algorithm.model.ListNode;

// url:https://leetcode.cn/problems/reverse-linked-list-ii/submissions/
public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] vals = new int[]{1,2,3,4,5};
        ListNode head = ListNode.buildLinkedList(vals);
        ListNode res = new ReverseLinkedList().reverseBetween(head, 3, 3);
        int i=1;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode turnHead=new ListNode(0,head);
        ListNode h=head;
        int idx=1;
        while(h!=null&&idx!=left){
            turnHead=turnHead.next;
            h=h.next;
            idx++;
        }
        if(turnHead.next==null){
            return head;
        }else{
            idx++;
            ListNode startTurn=h;
            ListNode h2=h.next;
            while(h2!=null&&idx<=right){
                h.next=h2.next;
                h2.next=startTurn;
                startTurn=h2;
                h2=h.next;
                turnHead.next=startTurn;
                idx++;
            }
        }
        return turnHead.val==0?turnHead.next:head;
    }
}
