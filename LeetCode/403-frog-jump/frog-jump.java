class Solution {
    public boolean canCross(int[] stones) {
        boolean [][] seen = new boolean [stones.length][stones.length + 1];
        return dfs(0, 0, stones, seen);
    } //canCross

    private boolean dfs(int pos, int k, int [] stones, boolean [][] seen) {
        //System.out.println(pos + "\t" + k);
        if (pos == stones.length - 1) {
            return true;
        } else if (k < 0 || seen[pos][k]) {
            return false;
        } //if

        seen[pos][k] = true;
        boolean res = false;

        int kMinusOne = has(stones[pos] + (k - 1), stones);
        if (kMinusOne != -1) {
            res = res || dfs(kMinusOne, k - 1, stones, seen);
        } //if
        
        int kSame = has(stones[pos] + (k), stones);
        if (kSame != -1) {
            res = res || dfs(kSame, k, stones, seen);
        } //if

        int kPlusOne = has(stones[pos] + (k + 1), stones);
        if (kPlusOne != -1) {
            res = res || dfs(kPlusOne, k + 1, stones, seen);
        } //if

        return res;
    } //dfs

    private int has(int val, int [] stones) {
        int l = 0, r = stones.length - 1;

        while (l <= r) {
            int m = l + (r - l)/2;
            if (stones[m] == val) {
                return m;
            } else if (stones[m] < val) {
                l = ++m;
            } else {
                r = --m;
            } //if
        } //while

        return -1;
    } //has
} //Sol