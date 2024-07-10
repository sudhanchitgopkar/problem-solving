class Solution {
    HashMap <Integer, List<Integer>> r;
    HashMap <Integer, List<Integer>> b;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        r = new HashMap <> ();
        b = new HashMap <> ();
        int [] sol = new int [n];

        for (int [] edge : redEdges) {
            if (!r.containsKey(edge[0])) {
                r.put(edge[0], new ArrayList<Integer> ());
            } //if
            r.get(edge[0]).add(edge[1]);
        } //for

        for (int [] edge : blueEdges) {
            if (!b.containsKey(edge[0])) {
                b.put(edge[0], new ArrayList<Integer> ());
            } //if
            b.get(edge[0]).add(edge[1]);
        } //for

        sol[0] = 0;
        for (int i = 1; i < n; i++) {
            int res1 = minDist(n, i, true);
            int res2 = minDist(n, i, false);
            sol[i] = res1 == -1 ? res2 : res2 == -1 ? res1 : Math.min(res1, res2);
        } //for 

        return sol;
    } //shortestAlternating

    private int minDist(int n, int target, boolean redStart) {
        boolean currRed = redStart;
        boolean [] rSeen = new boolean [n];
        boolean [] bSeen = new boolean [n];

        Queue <Integer> q = new LinkedList <> ();
        int dist = 0;

        q.offer(0);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == target) return dist;
                
                if (currRed) {
                    if (!r.containsKey(curr)) continue;
                    for (int next : r.get(curr)) {
                        if (!rSeen[next]) {
                            q.offer(next);
                            rSeen[next] = true;
                        } //if
                    } //for
                } else {
                    if (!b.containsKey(curr)) continue;
                    for (int next : b.get(curr)) {
                        if (!bSeen[next]) {
                            q.offer(next);
                            bSeen[next] = true;
                        } //if
                    } //for
                } //if
            } //for
            ++dist;
            currRed = !currRed;
        } //while

        return -1;
    } //minDist
} //Sol