class Solution {
    public int totalMoney(int n) {
        int sol = 28 * (n/7), offset = 0;

        for (int i = 0; i < n/7; i++){
            sol += offset;
            offset += 7;
        } //for
        
        for (int i = 1; i <= n % 7; i++) {
            sol += n/7 + i;
        } //for

        return sol;
    } //totalMoney
} //Sol