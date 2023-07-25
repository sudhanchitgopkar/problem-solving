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
    HashMap <Integer, ListNode> locs = new HashMap <> ();
    int size = 0;
    public Solution(ListNode head) {
       ListNode curr = head;
       int idx = 0;
       while (curr != null) {
           locs.put(idx++, curr);
           curr = curr.next;
       } //while
       size = idx;
    } //Sol
    
    public int getRandom() {
        Random r = new Random();
        return locs.get(r.nextInt(size)).val;
    } //getRand
} //Sol

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */