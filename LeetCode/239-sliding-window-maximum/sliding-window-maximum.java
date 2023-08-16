class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int soli = 0, n = nums.length, l = 0, r = 0;
        int [] sol = new int [n - k + 1];
        //int [] -> val, index
        PriorityQueue <int []> pq = new PriorityQueue <> (new Comparator<int []>() {
            @Override
            public int compare(int [] a, int [] b) {
                return Integer.compare(b[0], a[0]);
            } //compare
        });


        //populate pq with initial window
        for (; r < k; r++) {
            pq.offer(new int [] {nums[r], r});
        } //for

        sol[soli++] = pq.peek()[0];

        while (r < n) {
            pq.offer(new int [] {nums[r], r++});
            ++l;

            while (pq.peek()[1] < l) pq.poll();
            sol[soli++] = pq.peek()[0];
        } //while

        return sol;
    } //maxSlidingWindow
} //Sol