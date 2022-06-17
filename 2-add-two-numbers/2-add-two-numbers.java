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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l1ptr = l1, l2ptr = l2;
        ListNode head = new ListNode(), curr = head;
        int carry = 0;
        
        while (l1ptr != null && l2ptr != null) {
            curr.next = new ListNode((l1ptr.val + l2ptr.val + carry) % 10);
            carry = (l1ptr.val + l2ptr.val + carry) / 10;
            curr = curr.next;
            l1ptr = l1ptr.next;
            l2ptr = l2ptr.next;
        } //while
        
        while (l1ptr == null && l2ptr != null) {
            curr.next = new ListNode ((l2ptr.val + carry) % 10);
            carry = (l2ptr.val + carry) / 10;
            curr = curr.next;
            l2ptr = l2ptr.next;
        } //while
        
        while (l1ptr != null && l2ptr == null) {
            curr.next = new ListNode ((l1ptr.val + carry) % 10);
            carry = (l1ptr.val + carry) / 10;
            curr = curr.next;
            l1ptr = l1ptr.next;
        } //while
        
        if (carry == 1) curr.next = new ListNode(1);
        
        return head.next;
    } //addTwoNumbers
} //Sol