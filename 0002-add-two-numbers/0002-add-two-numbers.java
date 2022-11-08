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
        int l1val = l1.val, l2val = l2.val, currSum = l1val + l2val, carry = currSum >= 10 ? 1 : 0;
        ListNode sum = new ListNode (currSum % 10), head = sum;
        
        l1 = l1.next; l2 = l2.next;
        while (l1 != null || l2 != null) {
            l1val = l1 == null ? 0 : l1.val;
            l2val = l2 == null ? 0 : l2.val;
            currSum = l1val + l2val + carry;
            
            carry = currSum >= 10 ? 1 : 0;
            sum.next = new ListNode(currSum % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            sum = sum.next;
        } //while
        
        if (carry == 1) sum.next = new ListNode(1);
        
        return head;
    } //addTwoNums
} //Solution