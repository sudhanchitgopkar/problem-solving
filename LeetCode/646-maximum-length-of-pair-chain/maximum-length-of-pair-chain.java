class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.<int []>sort(pairs, (a, b) -> (Integer.compare(a[1], b[1])));
        int sol = 1, end = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                //System.out.println(pairs[i][0] + "," + pairs[i][1]);
                ++sol;
                end = pairs[i][1];
            } //if
        } //for
        
        return sol;
    } //findLongest
} //Sol