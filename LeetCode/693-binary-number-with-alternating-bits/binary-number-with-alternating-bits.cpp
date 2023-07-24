class Solution {
public:
    bool hasAlternatingBits(int n) {
        int alt = n % 2;

        while (n > 0) {
            if (alt != n % 2) return false;
            alt = alt == 1 ? 0 : 1;
            n = n >> 1;
        } //while

        return alt == 0;
    } //hasAlt
};