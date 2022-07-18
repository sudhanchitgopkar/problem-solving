class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        
        int prev = 1, prevprev = 1, curr = 0;
        
        for (int i = 2; i <= n; i++) {
            curr = prevprev + prev;
            prevprev = prev;
            prev = curr;
        } //for
        
        return curr;
    } //climb
} //Solution

/*
1   1
2   2
3   3
4   
*/