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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sol = new ListNode();
        ListNode head = sol;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val){
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            } //if
            
            head = head.next;
        } //while
        
        if (list1 == null) head.next = list2;
        else if (list2 == null) head.next = list1;
        
        return sol.next;
    } //merge2Lists
} //Solution