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
    public ListNode deleteMiddle(ListNode h) {
        if (h.next == null || h.next == null) return null;
        ListNode r = h, w = h, p = h;
        
        while (r != null && r.next != null) {
            p = w;
            w = w.next;
            r = r.next.next;
        } //while
        
        p.next = w.next;
        return h;
        
    }
}