/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       HashSet <ListNode> seen = new HashSet <> ();

       while (head != null) {
           if (seen.contains(head)) {
               return head;
           } else {
               seen.add(head);
           } //if

           head = head.next;
       } //while

       return null;
    } //detect
} //Sol