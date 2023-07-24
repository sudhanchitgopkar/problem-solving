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
        //cout << n << " % " << 2 << " = " << n % 2 << endl;
        if (n % 2 == 1 || n % 2 == -1) res *= x;
        return res;
    } //pow
};