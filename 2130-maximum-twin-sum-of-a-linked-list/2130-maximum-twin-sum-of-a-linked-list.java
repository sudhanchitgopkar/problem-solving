class Solution {
    public int pairSum(ListNode head) {
        ListNode mid = head, run = head.next;
        int maxSum = -1;

        //find halfway point
        while (run.next != null) {
            mid = mid.next;
            run = run.next.next;
        } //while

        //reverse all links after halfway
        reverse(mid.next);

        //iterate through twins and find max sum
        ListNode beg = head;
        while (run != null) {
            maxSum = Math.max(maxSum, beg.val + run.val);
            beg = beg.next;
            run = run.next;
        } //while

        return maxSum;
    } //pairSum

    private void reverse(ListNode head) {
        ListNode next = head.next;
        head.next = null;

        while (next != null) {
            ListNode nextnext = next.next;
            next.next = head;
            head = next;
            next = nextnext;
        } //while
    } //reverse

    private void reverse(ListNode prev, ListNode curr) {
        if (curr == null || curr.next == null) return;
        ListNode next = curr.next, nextnext = next.next;
        prev.next = next;
        next.next = curr;
        curr.next = nextnext;
        reverse(curr, nextnext);
    } //reverse

    private void printLL(ListNode curr) {
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        } //while
    } //printLL
} //Sol