class Solution {
    int [] par;
    public int makeConnected(int n, int[][] connections) {
        int redun = 0; //num redundant conns
        HashSet <Integer> sets = new HashSet <> (); //num sets

        //set up union find parent list
        par = new int [n];
        for (int i = 0; i < n; i++) par[i] = i;

        for (int [] con : connections) {
            if (find(con[0]) != find(con[1])) { //if not already connected
                union(con[0], con[1]); //connect them
            } else { //else (already connected)
                redun++; //this conn is redundant
            } //if
        } //for

        for (int i = 0; i < n; i++) {
            par[i] = find(i); //propogate up parents
            sets.add(par[i]); //add parents to set to count num disjoint nets
        } //for

        return sets.size() >= 1 && redun >= (sets.size() - 1) ? (sets.size() - 1) : -1;
    } //makeConn

    private void union (int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);
        par[p1 > p2 ? p1 : p2] = p1 < p2 ? p1 : p2;
        par[p1 > p2 ? n1 : n2] = p1 < p2 ? p1 : p2;
    } //union

    private int find(int child) {
        if (par[child] == child) return child;
        return find(par[child]);
    } //find

} //Sol