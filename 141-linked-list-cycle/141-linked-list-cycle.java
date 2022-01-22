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
        if (head == null) return false;
        ListNode tort = head, hare = head.next;
        
        while (hare != tort) {
            if (tort == null || hare == null || hare.next == null) {
                return false;
            } else {
                tort = tort.next;
                hare = hare.next.next;
            } //else
        } //while

        return true;
    } //hasCycle
} //Solution