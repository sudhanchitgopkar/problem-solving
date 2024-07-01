class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consec = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) ++consec;
            else consec = 0;
            if (consec == 3) return true;
        } //for
        
        return false;
    } //threeConsecOdd
} //Sol