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
    public boolean isPalindrome(ListNode head) {
       Stack <Integer> s = new Stack <Integer> ();
        
        ListNode ptr = head;
        
        while (ptr != null) {
            s.push(ptr.val);
            ptr = ptr.next;
        } //while
                
        while (head != null) {
            if(s.pop() != head.val)
                return false;
            head = head.next;
        } //while
        
        return true;
    } //isPalindrome
} //Solution