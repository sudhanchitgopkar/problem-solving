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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode origLast = head, last = origLast;
        while (origLast.next != null) {
            origLast = origLast.next;
        } //while
        last = origLast;

        ListNode curr = head, prev = null;
        while (curr != origLast) {
            if (curr.val >= x) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    head = head.next;
                } //if
                last.next = curr;
                curr.next = null;
                last = curr;
                if (prev == null) {
                    curr = head;
                } else {
                    curr = prev.next;
                } //if
            } else {
                prev = curr;
                curr = curr.next;
            } //if
        } //while

        if (curr.next != null && curr.val >= x) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    head = head.next;
                } //if
                last.next = curr;
                curr.next = null;
                last = curr;
                if (prev == null) {
                    curr = head;
                } else {
                    curr = prev.next;
                } //if
            } else {
                prev = curr;
                curr = curr.next;
            } //if

        return head;  
    } //partition
} //Solution