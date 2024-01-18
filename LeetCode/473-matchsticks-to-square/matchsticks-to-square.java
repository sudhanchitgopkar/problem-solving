class Solution {
    public boolean makesquare(int[] sticks) {        
        int sum = 0;
        for (int stick : sticks) {
            sum += stick;
        } //for

        //get the easy stuff out of the way
        if (sticks.length < 4 || sum % 4 != 0) return false;
        for (int stick : sticks) if (stick > sum/4) return false;

        //backtracking time
        return backtrack(0, sum/4, new int [4], sticks);
    } //makesquare

    private boolean backtrack(int i, int target, int [] sides, int [] sticks) {
        if (i == sticks.length) {
            return sides[0] == sides[1] && 
                    sides[1] == sides[2] && 
                    sides[2] == sides[3];
        } //if

        for (int j = 0; j < sides.length; j++) {
            if (sides[j] + sticks[i] > target) continue;
            sides[j] += sticks[i];
            if (backtrack(i + 1, target, sides, sticks)) return true;
            sides[j] -= sticks[i];
        } //for

        return false;
    } //backtrack
} //Sol