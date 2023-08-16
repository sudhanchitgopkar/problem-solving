class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int soli = 0, n = nums.length, l = 0, r = 0;
        int [] sol = new int [n - k + 1];
        PriorityQueue <Pair> pq = new PriorityQueue <> (new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return Integer.compare(b.val, a.val);
            } //compare
        });


        //populate pq with initial window
        for (; r < k; r++) {
            pq.offer(new Pair(nums[r], r));
        } //for

        sol[soli++] = pq.peek().val;

        while (r < n) {
            pq.offer(new Pair(nums[r], r++));
            ++l;

            while (pq.peek().index < l) pq.poll();
            sol[soli++] = pq.peek().val;
        } //while

        return sol;
    } //maxSlidingWindow
} //Sol

class Pair {
    protected int val, index;
    public Pair (int val, int index) {
        this.val = val;
        this.index = index;
    } //Pair
} //Pair