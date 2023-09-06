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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0, spillover = -1;
        ListNode curr = head;
        ListNode [] sol = new ListNode [k];

        while (curr != null) {
            curr = curr.next;
            len++;
        } //while

        spillover = len % k;
        curr = head;
        sol[0] = curr;

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (len/k) + (spillover > 0 ? 1 : 0) - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                } //if
            } //for

            if (curr != null) {
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp;
            } //if

            sol[i] = curr;
            --spillover;
        } //for

        return sol;
    } //splitListIntoParts
} //Sol