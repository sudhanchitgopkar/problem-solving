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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) return head;

        ListNode next = head.next, sol = head;
        while (next != null) {
            ListNode add = new ListNode(gcd(head.val, next.val));
            insert(head, add);
            head = head.next.next;
            next = next.next;
        } //while
        
        return sol;
    } //insertGCD

    private void insert(ListNode head, ListNode insert) {
        ListNode temp = head.next;
        head.next = insert;
        insert.next = temp;
    } //insert

    private int gcd(int a, int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    } //gcd
} //Sol