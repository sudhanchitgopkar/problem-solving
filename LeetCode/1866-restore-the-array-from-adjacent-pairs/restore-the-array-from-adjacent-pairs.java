class Solution {
    public int[] restoreArray(int[][] adjPairs) {
        HashMap <Integer, List<Integer>> adj = new HashMap <> (); 
        HashMap <Integer, Integer> freq = new HashMap <> ();

        //set up adj list, get freq of elems
        for (int [] pair : adjPairs) {
            freq.put(pair[0], freq.getOrDefault(pair[0], 0) + 1);
            freq.put(pair[1], freq.getOrDefault(pair[1], 0) + 1);

            if (!adj.containsKey(pair[0])) {
                adj.put(pair[0], new ArrayList <Integer> ());
            } //if

            if (!adj.containsKey(pair[1])) {
                adj.put(pair[1], new ArrayList <Integer> ());
            } //if

            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        } //for

        //find startpoint (only one attachment)
        int start = -1;
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                start = key;
                break;
            } //if
        } //for

        List<Integer> res = dfs(start, new HashSet <Integer> (), adj);
        int [] sol = new int [res.size()];
        for (int i = 0; i < res.size(); i++) sol[i] = res.get(i);
        return sol;
    } //restore

    private List<Integer> dfs(int curr, HashSet <Integer> seen, HashMap <Integer, List<Integer>> adj) {
        seen.add(curr);
        for (int next : adj.get(curr)) {
            if (!seen.contains(next)) {
                System.out.print(curr + "->" + next +",");
                seen.add(next);
                List<Integer> res = dfs(next, seen, adj);
                res.add(curr);
                return res;
            } //if
        } //for

        return new ArrayList <Integer> (Arrays.asList(curr));
    } //dfs
} //Sol