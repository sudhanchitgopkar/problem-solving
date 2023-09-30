class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length; 
        if (n < 3) return false;
        int [] pre = new int [n], suf = new int [n];
        PriorityQueue <Integer> pq = new PriorityQueue <> ();

        pre[1] = nums[0];
        for (int i = 2; i < n; i++) {
            pre[i] = Math.min(pre[i - 1], nums[i - 1]);
        } //for

        pq.offer(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (!pq.isEmpty() && pq.peek() <= pre[i]) {
                pq.poll();
            } //while

            suf[i] = pq.isEmpty() ? Integer.MIN_VALUE : pq.peek();
            pq.offer(nums[i]);
        } //for

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > pre[i] && nums[i] > suf[i] && pre[i] < suf[i]) {
                return true;
            } //if
        } //for

        return false;
    } //find132
} //Sol