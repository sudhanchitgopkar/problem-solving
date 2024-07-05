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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int gMin = Integer.MAX_VALUE, gMax = 0;
        int firstCritical = -1, prevCritical = -1, idx = 1;

        ListNode dummy = new ListNode(head.val);
        dummy.next = head;
        head = dummy;
        
        while (head != null) {
            if (isNextCritical(head)) {
                System.out.println(idx);
                //update first critical if applicable
                if (firstCritical == -1) {
                    firstCritical = idx;
                } //if

                //recalc minDist, maxDist
                if (prevCritical != -1 && idx - prevCritical < gMin) {
                    gMin = idx - prevCritical;
                } //if
                gMax = idx - firstCritical;

                //update prev critical
                prevCritical = idx;
            } //if
            
            head = head.next;
            idx++;
        } //while

        if (prevCritical == firstCritical) return new int [] {-1, -1};
        return new int [] {gMin, gMax};
    } //nodesBetweenCriticalPoints

    private boolean isNextCritical(ListNode ln) {
        if (ln.next == null || ln.next.next == null) 
            return false; //doesn't exist or have next node
        if (ln.next.val > ln.val && 
            ln.next.val > ln.next.next.val) 
                return true; //local max
        if (ln.next.val < ln.val && 
            ln.next.val < ln.next.next.val) 
                return true; //local min
        return false;
    } //isNextCritical
} //Sol