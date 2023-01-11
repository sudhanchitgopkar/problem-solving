class Solution {
    HashSet <Integer> used = new HashSet <> ();
    HashMap <Integer, List <Integer>> graph = new HashMap <> ();
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {  
        HashSet<Integer> targets = new HashSet <> ();
        for (int [] edge : edges) {
            if(!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<Integer> ());
            if(!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<Integer> ());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        } //for

        for (int i = 0; i < n; i++) if (hasApple.get(i)) targets.add(i);
        dfs(0,targets,new HashSet<Integer>());
        return Math.max((used.size()-1)*2,0);
    } //minTime

    private void dfs(int curr, HashSet<Integer> targets, HashSet <Integer> seen) {
        if (targets.isEmpty()) return;
        seen.add(curr);
        if (targets.contains(curr)) {
            targets.remove(curr);
            used.addAll(seen);
            //return;
        } //if

        for (int next : graph.get(curr)) {
            if (seen.contains(next)) continue;
            dfs(next,targets,seen);
        } //for
        seen.remove(curr);
    } //dfs
} //Sol