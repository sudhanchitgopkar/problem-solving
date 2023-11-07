class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int [] ttk = new int [n];

        for (int i = 0; i < n; i++) {
            ttk[i] = (int) Math.ceil(dist[i] * 1.0/speed[i]);
        } //for

        Arrays.sort(ttk);

        for (int i = 0; i < n; i++) {
            if (i >= ttk[i]) return i;
        } //for

        return n;
    } //elimMax
} //Sol