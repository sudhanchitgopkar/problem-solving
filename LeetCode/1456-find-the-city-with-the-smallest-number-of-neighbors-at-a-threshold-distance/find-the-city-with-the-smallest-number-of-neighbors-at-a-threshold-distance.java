class Solution {
    HashMap <Integer, List<int []>> adj;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int minNeighbors = Integer.MAX_VALUE, cityID = -1;
        adj = new HashMap <> ();

        //populate adj
        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<int[]> ());

        for (int [] edge : edges) {
            adj.get(edge[0]).add(new int [] {edge[1], edge[2]});
            adj.get(edge[1]).add(new int [] {edge[0], edge[2]});
        } //for

        for (int i = 0; i < n; i++) {
            int [] seen = new int [n];
            for (int j = 0; j < n; j++) seen[j] = Integer.MIN_VALUE;
            seen[i] = Integer.MAX_VALUE;
            int neighbors = countNeighbors(i, distanceThreshold, seen);
            if (neighbors <= minNeighbors) {
                minNeighbors = neighbors;
                cityID = i;
            } //if
        } //for

        return cityID;
    } //findTheCity

    private int countNeighbors(int curr, int distLeft, int [] seen) {
        for (int [] next : adj.get(curr)) {
            int loc = next[0], dist = next[1];
            if (seen[loc] < (distLeft - dist) && dist <= distLeft) {
                seen[loc] = distLeft - dist;
                countNeighbors(loc, distLeft - dist, seen);
            } //if
        } //for

        int sol = 0;
        for (int city : seen) if (city >= 0) ++sol;
        return sol;
    } //countNeighbors
} //Sol