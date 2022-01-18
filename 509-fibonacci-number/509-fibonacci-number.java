class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        
        int p = 0, c = 1;
        for (int i = 1; i < n; i++) {
            int t = c;
            c += p;
            p = t;
        } //for
        
        return c;
    } //fib
} //Solution