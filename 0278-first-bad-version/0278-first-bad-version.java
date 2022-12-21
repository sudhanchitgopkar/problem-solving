/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n, min = n;
        
        while (l < r) {
            int m = l + ((r - l) / 2);
            if (isBadVersion(m))
                if (m == 1 || !isBadVersion(m-1)) return m;
                else r = m - 1;
            else l = m + 1;
        } //while

        return l;
    } //firstBad
} //Sol