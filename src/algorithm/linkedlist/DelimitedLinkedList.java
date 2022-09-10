package algorithm.linkedlist;

import algorithm.model.ListNode;

// url:https://leetcode.cn/problems/partition-list/submissions/
public class DelimitedLinkedList {

    public ListNode partition(ListNode head, int x) {
        ListNode biggerLinkedList=new ListNode(-1,null);
        ListNode smallerLinkedList=new ListNode(-1,head);

        ListNode previousH=smallerLinkedList;
        ListNode biggerH=biggerLinkedList;
        while(previousH.next!=null){
            ListNode cntH=previousH.next;
            if(cntH.val>=x){
                biggerH.next=cntH;
                previousH.next=cntH.next;
                cntH.next=null;
                biggerH=biggerH.next;
            }else{
                previousH=previousH.next;
            }
        }
        if(biggerLinkedList.next==null){
            return head;
        }else{
            if(smallerLinkedList.next==null){
                return biggerLinkedList.next;
            }else{
                previousH.next=biggerLinkedList.next;
                biggerLinkedList.next=null;
                return smallerLinkedList.next;
            }
        }

    }
}
