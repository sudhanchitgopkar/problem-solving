class Solution {
    int [] sol;
    char [] id;
    List<List<Integer>> graph;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        sol = new int [n];
        int [] freq = new int [26];
        id = labels.toCharArray();
        graph = new ArrayList<List<Integer>> ();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer> ());
        } //for

        for (int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        } //for

        dfs(0,0,freq);
        return sol;
    } //countSub

    private int [] dfs (int curr, int parent, int [] freq) {
        int [] newFreq = Arrays.copyOf(freq,freq.length);
        for (int next : graph.get(curr)) {
            if (next == parent) continue;
            int [] res = dfs(next,curr,freq);
            for (int i = 0; i < res.length; i++) newFreq[i] += res[i] - freq[i];
        } //for

        sol[curr] = ++newFreq[id[curr]-'a'];
        return newFreq;
    } //dfs
} //Sol