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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode curr = head, runner = head.next;
        
        while (runner != null) {
            while (runner != null && runner.val == curr.val) runner = runner.next;
            curr.next = runner;
            curr = curr.next;
        } //while
        
        return head;
    } //deleteDups
} //Sol