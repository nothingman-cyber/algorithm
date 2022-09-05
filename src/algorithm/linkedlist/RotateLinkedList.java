package algorithm.linkedlist;

import algorithm.model.ListNode;

// url:https://leetcode.cn/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode-solutio-woq1/
public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode t5 = new ListNode(5);
        ListNode t4 = new ListNode(4,t5);
        ListNode t3 = new ListNode(3,t4);
        ListNode t2 = new ListNode(2,t3);
        ListNode t1 = new ListNode(1,t2);
        RotateLinkedList rotateLinkedList = new RotateLinkedList();
        ListNode res = rotateLinkedList.rotateRight(t1, 4);
        int i = 0;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int num=0;
        ListNode cnt=head;
        while(cnt!=null){
            num++;
            cnt=cnt.next;
        }
        int tailPosition=k%num;
        ListNode useHead=new ListNode(-1,head);
        ListNode tail=head,start=head,newTail=useHead,oldTail=null;
        int count=1;
        while(tail!=null){
            if(tail.next==null){
                oldTail=tail;
            }
            if(tailPosition<count&&count<=num){
                start=start.next;
                newTail=newTail.next;
            }
            tail=tail.next;
            count++;
        }
        if(oldTail==newTail){
            return head;
        }else{
            // head -- newTail -- start -- oldTail
            oldTail.next=head;
            newTail.next=null;
            return start;
        }
    }
}
