class Solution {
    public int maxDistToClosest(int[] seats) {
        int l = 0, r = 0;
        int lMax = 0, gMax = 0;
        
        while (r <= seats.length-1) {
            if (seats[r] == 1) {
                if (seats[l] == 0)
                    lMax = r-l;
                else
                    lMax = (r-l)/2;
                l = r++;
            } //if
            else
                r++;
            if (lMax > gMax)
                gMax = lMax;
        } //while
        
        if (seats[l] == 1 && r-l > gMax)
            return r-l-1;
        else
            return gMax;
        
    } //maxDistToClosest
} //Solution