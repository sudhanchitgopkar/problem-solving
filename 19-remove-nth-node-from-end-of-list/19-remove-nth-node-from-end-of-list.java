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
        if (head.next == null) return null;
        ListNode run = head, walk = head, prev = head;
        
        for (int i = 0; i < n; i++) run = run.next;
        
        while (run != null) {
            prev = walk;
            walk = walk.next;
            run = run.next;
        } //while
        
        prev.next = walk.next == null ? null : walk.next;        
        return walk == head ? head.next : head;
    } //removeNthFromEnd
} //Solution