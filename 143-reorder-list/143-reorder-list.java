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
    public void reorderList(ListNode head) {
        //1.findMid
        ListNode slow = head, curr = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = curr;
            curr = curr.next;
            fast = fast.next.next;
        } //while
        
        //now curr is at the midPoint
        slow.next = null;
        ListNode prev = null;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } //while
        
        ListNode newHead = head, mid = prev;
        
        while (mid != null && newHead != null) {
            ListNode next = newHead.next;
            ListNode midNext = mid.next;
            
            newHead.next = mid;
            mid.next = next;
            
            prev = newHead;
            newHead = next;
            mid = midNext;
        } //while
        
        if (newHead == null && mid != null) {
            prev.next.next = mid;
        } //if
    } //reorderList
} //Solution