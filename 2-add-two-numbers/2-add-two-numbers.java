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
        
        while (l1ptr != null || l2ptr != null) {
            int sum = 0;
            
            if (l1ptr != null) {
                sum += l1ptr.val;
                l1ptr = l1ptr.next;
            } //if
            
            if (l2ptr != null) {
                sum += l2ptr.val;
                l2ptr = l2ptr.next;
            } //if
            
            curr.next = new ListNode((sum + carry) % 10);
            carry = (sum + carry) / 10;
            
            curr = curr.next;
        } //while
        
        if (carry == 1) curr.next = new ListNode(1);
        
        return head.next;
    } //addTwoNumbers
} //Sol