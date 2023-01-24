class Solution {
    HashMap <Integer,HashSet<Integer>> adj = new HashMap <> ();
    public int[] findRedundantConnection(int[][] edges) {
        for (int [] edge : edges) {
            //if curr edge is redundant
            if (isRedundant(edge[0],edge[1],edge[0])) return edge;
            //else add edge to adjacency list
            if (!adj.containsKey(edge[0])) 
                adj.put(edge[0],new HashSet <Integer> ());
            if (!adj.containsKey(edge[1])) 
                adj.put(edge[1],new HashSet <Integer> ());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        } //for
        
        return new int [] {-1,-1}; //unreachable
    } //findRedundant


    private boolean isRedundant (int start, int target, int parent) {
        if (!adj.containsKey(start)) return false;
        if (adj.get(start).contains(target)) return true;

        for (int next : adj.get(start)) {
            if (next != parent) 
                if(isRedundant(next, target, start)) return true;
        } //for

        return false;
    } //isRedundant
} //Sol