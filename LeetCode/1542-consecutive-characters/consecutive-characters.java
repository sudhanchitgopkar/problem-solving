class Solution {
    public int maxPower(String s) {
        int l = 0, r = 0, max = 1;

        while (r < s.length()) {
            if (s.charAt(r) != s.charAt(l)) {
                l = r++;
            } else {
                ++r;
            } //if
            max = Math.max(max, r - l);
        } //while

        return max;
    } //maxPower
} //Sol