class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int [] r = new int [n];
        PriorityQueue <Pair> pq = new PriorityQueue <> ();
        List<List<Integer>> sol = new ArrayList <> ();

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(nums1[i] + nums2[r[i]], i));
        } //for

        while (k-- > 0 && !pq.isEmpty()) {
            Pair curr = pq.poll();
            sol.add(new ArrayList<Integer> (Arrays.asList(nums1[curr.idx], nums2[r[curr.idx]])));
            r[curr.idx]++;

            if (r[curr.idx] < m) {
                pq.offer(new Pair(nums1[curr.idx] + nums2[r[curr.idx]], curr.idx));
            } //if
        } //while

        return sol;
    } //kSmallest
} //Sol

class Pair implements Comparable<Pair>{
    protected int sum, idx;

    public Pair (int sum, int idx) {
        this.sum = sum;
        this.idx = idx;
    } //Pair

    @Override
    public int compareTo(Pair p) {
        return p.sum < sum ? 1 : p.sum == sum ? 0 : -1;
    } //int
} //Pair