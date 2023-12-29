class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length(), l = 0, r = 1, sol = 0;
        char [] cols = colors.toCharArray();
        boolean [] popped = new boolean [n];

        while (r < n) {
            if (popped[l]) {
                ++l;
            } else if (l == r) {
                ++r;
            } else if (cols[l] == cols[r]) {
                if (neededTime[l] < neededTime[r]) {
                    sol += neededTime[l];
                    popped[l++] = true;
                } else {
                    sol += neededTime[r];
                    popped[r++] = true;
                } //if
            } else {
                l++;
                r++;
            } //if
        } //while

        return sol;
    } //minCost
} //Sol