class Solution {
    public int tribonacci(int n) {
        int n0 = 0, n1 = 1, n2 = 1, ni = 2;
        if (n == 0) return n0;
        else if (n == 1) return n1;
        else if (n == 2) return n2;

        for (int i = 3; i <= n; i++) {
            ni = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = ni;
        } //for

        return ni;
    } //trib
} //Sol

// if (n == 0) return 0; if (n <= 2) return 1; return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);    