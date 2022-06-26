class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int [] l = new int [k+1];
        int [] r = new int [k+1];
        int max = 0;
        
        for (int i = 1; i < l.length; i++) {
            l[i] = l[i-1] + cardPoints[i-1];
            r[i] = r[i-1] + cardPoints[cardPoints.length - i];
        } //for
        
        for (int i = 0; i < l.length; i++) {
            max = Math.max(max, l[i] + r[r.length-i-1]);
        } //for
        
        return max;
    } //maxScore
} //Sol