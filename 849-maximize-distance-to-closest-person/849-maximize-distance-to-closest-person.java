class Solution {
    public int maxDistToClosest(int[] seats) {
        int l = 0, r = 0;
        int lMax = 0, gMax = 0;
        
        while (r < seats.length) {
            if (seats[r] == 1 && seats[l] == 0) {
                lMax = r-l;
                l = r++;
            } else if (seats[r] == 1) {
                lMax = (r-l)/2;
                l = r++;
            } else {
                r++;
            } //if
            gMax = lMax > gMax ? lMax : gMax;
        } //while
        
        if (seats[l] == 1 && --r-l > gMax)
            return r-l;
        else
            return gMax;
    } //maxDistToClosest
} //Solution

/*
        int l = 0, r = 0;
        int lMax = 0, gMax = 0;
        
        while (r < seats.length) {
            if (seats[r] == 1) {
                if (seats[l] == 0)
                    lMax = r-l;
                else
                    lMax = (r-l)/2;
                l = r;
            } //if
            r++;
            
            gMax = lMax > gMax ? lMax : gMax;
        } //while
        
        if (seats[l] == 1 && --r-l > gMax)
            return r-l;
        else
            return gMax;
*/