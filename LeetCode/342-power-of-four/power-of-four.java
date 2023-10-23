class Solution {
    public boolean isPowerOfFour(int n) {
        double dn = n * 1.0;
        while (dn > 1 && dn % 1 == 0) dn /= 4;
        return dn == 1;
    } //Sol
} //isPowerOfFour

