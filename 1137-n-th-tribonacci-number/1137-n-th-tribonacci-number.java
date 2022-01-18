class Solution {
    public int tribonacci(int n) {
        int pp = 0, p = 1, c = 1;
        if (n < 2) return n;
        if (n == 2) return 1;
        
        for (int i = 3; i <= n; i++) {
            int t = c;
            c += p + pp;
            pp = p;
            p = t;
        } //for
        
        return c;
    } //tribonacci
} //solution