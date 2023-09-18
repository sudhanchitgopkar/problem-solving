class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue <int []> pq = new PriorityQueue <> 
            ((int [] a, int [] b) -> a[0] < b[0] ? -1 : 
            a[0] > b[0] ? 1 : a[1] < b[1] ? -1 : 1);
        int [] sol = new int [k];
        int i = 0;

        for (int [] a : mat) {
            int sum = IntStream.of(a).sum();
            pq.offer(new int [] {sum, i++});
        } //for

        i = 0;
        while (k-- > 0) {
            sol[i++] = pq.poll()[1];
        } //while

        return sol;
    } //kWeakest
} //Sol