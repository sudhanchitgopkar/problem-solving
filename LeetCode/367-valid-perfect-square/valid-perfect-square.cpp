class Solution {
public:
    bool isPerfectSquare(int num) {
        int l = 1, r = num/2 + 1;

        while (l <= r) {
            long long m = l + (r - l)/2;
            if (m * m == num) {
                return true;
            } else if (m * m > num) {
                r = --m;
            } else {
                l = ++m;
            } //if
        } //while

        return false;
    } //isPerfectSquare
};