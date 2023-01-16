class Solution {
    public int[][] insert(int[][] intervals, int[] toAdd) {
        int l = -1, r = -1, n = intervals.length;
        List <int []> sol = new ArrayList <> ();

        for (int i = 0; i < n; i++) {
            int [] curr = intervals[i];
            if (curr[0] <= toAdd[0] && toAdd[0] <= curr[1]) l = i;
            if (curr[0] <= toAdd[1] && toAdd[1] <= curr[1]) r = i;
        } //for

        toAdd[0] = l == -1 ? toAdd[0] : intervals[l][0];
        toAdd[1] = r == -1 ? toAdd[1] : intervals[r][1] > toAdd[1] ? intervals[r][1] : toAdd[1];

        int i = 0;
        for (; i < n; i++) 
            if (intervals[i][0] < toAdd[0]) 
                sol.add(intervals[i]);
            else break;
        sol.add(toAdd);
        for (; i < n; i++)
            if (intervals[i][0] > toAdd[1])
                sol.add(intervals[i]);
        
        i = 0;
        int [][] ret = new int [sol.size()][2];
        for (; i < sol.size(); i++) ret[i] = sol.get(i);
        return ret;
    } //insert
} //Sol

