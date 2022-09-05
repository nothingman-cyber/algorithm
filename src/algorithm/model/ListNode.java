package algorithm.model;

/**
 * 算法链表节点，可以通用到几乎所有的题目中去
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
