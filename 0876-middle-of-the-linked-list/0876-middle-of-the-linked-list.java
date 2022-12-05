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
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode walk = head, run = head;
        
        while (run != null && run.next != null) {
            run = run.next.next;
            walk = walk.next;
        } //while
        
        return walk;
    }
}