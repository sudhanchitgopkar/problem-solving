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
        if (head == null) return head; //edge
        
        ListNode run = head, walk = head, count = head;
        int len = 0;
       
        for (len = 0; count != null; len++) count = count.next;      

        k = k % len;
        if (k == 0) return head;

        for (int i = 0; i < k; i++) run = run.next;
                    
        while (run.next != null) {
            run = run.next;
            walk = walk.next;
        } //while
        
        ListNode sol = walk.next;
        
        walk.next = null;
        run.next = head;
        
        return sol;
    } //rotateRight
} //Sol