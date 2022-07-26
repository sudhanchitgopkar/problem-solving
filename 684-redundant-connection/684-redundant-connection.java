class Solution {
    int [] parents;
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int [edges.length+1];
        //set each parent to itself
        for (int i = 0; i < parents.length; i++) parents[i] = i;
        
        for (int [] edge : edges) {
            int e0parent = findParent(edge[0]);
            int e1parent = findParent(edge[1]);
            if (e0parent == e1parent) return edge;
            parents[e1parent] = e0parent;
        } //for
        
        return new int [] {}; //should be unreachable
    } //findRedundant
    
    private void union(int parent, int node) {
        if (parents[parent] != parent) union(parents[parent],node);
        parents[node] = parent;
    } //union
    
    private int findParent(int node) {
        if (parents[node] != node) return findParent(parents[node]);
        return node;
    } //findParent
} //Sol