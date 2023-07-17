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
        Deque <Integer> d1 = new ArrayDeque <> (), d2 = new ArrayDeque <> ();
        ListNode sol = null;
        int carry = 0; 

        while (l1 != null) {
            d1.addLast(l1.val);
            l1 = l1.next;
        } //while

        while (l2 != null) {
            d2.addLast(l2.val);
            l2 = l2.next;
        } //while

        while (d1.size() != d2.size()) {
            if (d1.size() < d2.size()) {
                d1.addFirst(0);
            } else {
                d2.addFirst(0);
            } //if
        } //while

        while (!d1.isEmpty()) {
            int res = d1.pollLast() + d2.pollLast() + carry;
            carry = res >= 10 ? 1 : 0;
            if (sol == null) {
                sol = new ListNode (res % 10);
            }else {
                ListNode newHead = new ListNode (res % 10, sol);
                sol = newHead;
            } //if
        } //while

        if (carry == 1) {
            ListNode newHead = new ListNode (1, sol);
            sol = newHead;
        } //if
        
        return sol;
    } //addTwoNumbers
} //Sol

