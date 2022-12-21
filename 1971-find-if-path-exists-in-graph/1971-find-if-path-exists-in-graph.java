class Solution {
    List<Set<Integer>> graph;
    boolean [] seen;
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        if (source == dest) return true;
        graph = new ArrayList<Set<Integer>> ();
        seen = new boolean [n];
        for (int i = 0; i < n; i++) graph.add(new HashSet<Integer> ());
       
        for (int [] edge : edges) {
           graph.get(edge[0]).add(edge[1]);
           graph.get(edge[1]).add(edge[0]);
        } //for

        return checkValid(graph, source, dest);
    } //validPath

    private boolean checkValid(List<Set<Integer>> graph, int curr, int dest) {
        if (seen[curr]) return false;
        if (graph.get(curr).contains(dest)) return true;
        seen[curr] = true;
        for (int node : graph.get(curr)) if (checkValid(graph,node,dest)) return true;
        return false;
    } //checkValid
} //Sol