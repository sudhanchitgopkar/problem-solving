class Solution {
public:
    int hammingWeight(uint32_t n) {
        int sol = 0;
        while (n) {
            if ((n&1) > 0) ++sol;
            n >>= 1;
        } //while
        return sol;
    } //hamming
};