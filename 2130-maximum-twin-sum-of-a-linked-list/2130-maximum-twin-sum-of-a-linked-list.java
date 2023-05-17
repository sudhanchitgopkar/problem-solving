class Solution {
    public int pairSum(ListNode head) {
        ListNode mid = head, run = head.next;
        Stack <Integer> st = new Stack <> ();
        int maxSum = -1;

        //find halfway point
        while (run.next != null) {
            mid = mid.next;
            run = run.next.next;
        } //while

        mid = mid.next;

        //add all remaining to stack
        while (mid != null) {
            st.push(mid.val);
            mid = mid.next;
        } //while


        //get max twin sum
        ListNode curr = head;
        while (!st.isEmpty()) {
            maxSum = Math.max(maxSum, st.pop() + curr.val);
            curr = curr.next;
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
