class Solution {
    public int minGroups(int[][] intervals) {
        int sol = 0, n = intervals.length;

        java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty() && pq.peek() < intervals[i][0]) {
                pq.remove();
            } //if
            pq.add(intervals[i][1]);
        } //for

        return pq.size();
    } //minGroups
} //Sol