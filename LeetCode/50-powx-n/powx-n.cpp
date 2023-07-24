class Solution {
public:
    double myPow(double x, int n) {
        double sol = pls(x, n);
        cout << sol;
        return n < 0 ? 1.0/sol : sol;
    } //myPow
    
    double pls(double x, int n) {
        if (n == 0) return 1.0;

        double res = pls(x, n/2);
        res *= res;
        if (n % 2 == 0) return res;
        return res * x;
    } //pow
};