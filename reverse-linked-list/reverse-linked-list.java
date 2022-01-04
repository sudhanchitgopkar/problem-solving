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
    public ListNode reverseList(ListNode head) {
        
            if (head == null || head.next == null)
                return head;
        
            ListNode curr = head;
            ListNode prev = head;
            ListNode next = head.next;
        
            curr.next = null;
            prev = curr;
            curr = next;
            
            if(next.next != null)
                next = next.next;
            else {
                next.next = prev;
                head = next;
                return head;
            }
        
            while(next.next != null) {
                curr.next = prev;
                prev = curr;
                curr = next;
                next = next.next;
            } //while
        
            curr.next=prev;
            next.next = curr;
            head = next;
            return head;
            
            
    } //revList
} //Solution