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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null, curr = head, next = head, fast = head;
        
        for (int i = 0; i < n; i++)
            fast = fast.next;
        
        while (fast != null) {
            prev = curr;
            fast = fast.next;
            curr = curr.next;
        } //while
        
        next = curr.next;
        if (prev != null)
            prev.next = next;
        else 
            return next;
        
        return head;
    } //removeNthFromEnd
} //Solution