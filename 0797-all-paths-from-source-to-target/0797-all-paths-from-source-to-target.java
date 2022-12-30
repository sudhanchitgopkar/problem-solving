class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        sol = new ArrayList<List<Integer>> ();
        dfs(new ArrayList<Integer>(Arrays.asList(0)), graph, 0);
        return sol;
    } //allPaths

    public void dfs(List<Integer> visited, int [][] graph, int curr) {
        if (curr == graph.length-1) {
            sol.add(new ArrayList<Integer>(visited));
            return;
        } //if

        for (int node : graph[curr]) {
            visited.add(node);
            dfs(visited, graph, node);
            visited.remove(visited.size()-1);
        } //for
    } //dfs
} //Sol