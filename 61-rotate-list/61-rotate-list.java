/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        
        ListNode run = head, walk = head, prev = head, count = head;
        int len = 0;
       
        while (count != null) {count = count.next; len++;}
        k = k % len;
        if (k == 0) return head;

        for (int i = 0; i < k; i++) run = run.next;
        
        while (run.next != null) {
            run = run.next;
            prev = walk;
            walk = walk.next;
        } //while
        
        prev = walk.next;
        walk.next = null;
        run.next = head;
        
        return prev;
    } //rotateRight
} //Sol