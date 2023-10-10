class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int [] {-1, -1};
        int first = findFirst(nums, target);
        if (first == -1) return new int [] {-1, -1};
        int last = findLast(nums, first, target);
        return new int [] {first, last};
    } //searchRange

    private int findFirst(int [] n, int t) {
        int l = 0, r = n.length - 1, sol = -1;
        while (l <= r) {
            int m = l + (r - l)/2;

            if (n[m] > t) {
                r = --m;
            } else if (n[m] < t) {
                l = ++m;
            } else {
                sol = m;
                r = --m;
            } //if
        } //while

        return sol;
    } //findFirst

    private int findLast(int [] n, int l, int t) {
        int r = n.length - 1, sol = -1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (n[m] > t) {
                r = --m;
            } else if (n[m] < t) {
                l = ++m;
            } else {
                sol = m;
                l = ++m;
            } //if
        } //while

        return sol;
    } //findLast
} //Sol