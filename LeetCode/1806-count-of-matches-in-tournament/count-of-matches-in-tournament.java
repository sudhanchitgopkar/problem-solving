class Solution {
    public int numberOfMatches(int n) {
        int sol = 0; 

        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                sol += n;
            } else {
                n = (n - 1)/2;
                sol += n++;
            } //if
        } //while

        return sol;
    } //numMatches
} //Sol