/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null)
            return false;
        
        ListNode tort = head;
        ListNode hare = head.next;
        
        while (tort != null && hare != null) {
            if (tort == hare)
                return true;
            else if (hare.next == null)
                return false;
            tort = tort.next;
            hare = hare.next.next;
        } //while
        
        return false;
    } //hasCycle
} //Solution