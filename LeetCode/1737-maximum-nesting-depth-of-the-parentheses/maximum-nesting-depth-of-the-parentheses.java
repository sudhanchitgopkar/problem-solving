class Solution {
    public int maxDepth(String s) {
        int depth = 0, sol = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                sol = Math.max(++depth, sol);
            } else if (c == ')') {
                --depth;
            } //if
        } //for
        
        return sol;
    } //maxDepth
} //Sol