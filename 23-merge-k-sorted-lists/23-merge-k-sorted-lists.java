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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode(), curr = head;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length ,(a,b) -> a.val-b.val);

        
        for (ListNode l : lists) {
            if (l != null)
                pq.add(l);
        } //for
        
        while (!pq.isEmpty()) {
            curr.next = pq.poll(); 
            if (curr.next.next != null) {
                pq.add(curr.next.next);
            } //if
            curr = curr.next;
        } //while
        
        return head.next;
    } //mergeKLists
} //Sol