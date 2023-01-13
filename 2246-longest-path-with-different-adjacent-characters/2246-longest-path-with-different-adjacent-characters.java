class Solution {
    List<List<Integer>> children;
    char [] id;
    int max = 0;
    public int longestPath(int[] parent, String s) {
        children = new ArrayList<List<Integer>> ();
        id = s.toCharArray();

        for (int i = 0; i < parent.length; i++) children.add(new ArrayList<> ());
        for (int i = 1; i < parent.length; i++) children.get(parent[i]).add(i);
        
        dfs(0,-1);
        return max;
    } //longestPath

    private int dfs(int curr, int parent) {
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int child : children.get(curr)) {
            int res = dfs(child,curr);
            if (id[child] != id[curr]) pq.offer(res);
        } //for

        int hi1 = pq.isEmpty() ? 0 : pq.poll(), 
        hi2 = pq.isEmpty() ? 0 : pq.poll();
        max = Math.max(max, hi1 + hi2 + 1);
        return ++hi1;
    } //dfs
} //Sol