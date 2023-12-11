class Solution {
    public int findSpecialInteger(int[] a) {
        int n = a.length, l = 0, r = 0;

        while (r < n) {
            if (a[l] != a[r]) l = r++;
            else if (r - l + 1 > n/4) return a[r];
            else r++;
        } //while

        return -1; //unreachable
    } //findSpec
} //Sol