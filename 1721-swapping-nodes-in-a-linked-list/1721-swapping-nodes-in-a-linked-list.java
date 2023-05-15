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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode beg = head, end = head, run = head;
        //get k - 1 from beginning
        for (int i = 1; i < k; i++) {
            beg = beg.next;
        } //for

        //get k - 1 from end
        for (int i = 0; i < k; i++) {
            run = run.next;
        } //for

        while (run != null) {
            run = run.next;
            end = end.next;
        } //while

        //swap 
        int temp = beg.val;
        beg.val = end.val;
        end.val = temp;

        return head;
    } //swap
} //Sol