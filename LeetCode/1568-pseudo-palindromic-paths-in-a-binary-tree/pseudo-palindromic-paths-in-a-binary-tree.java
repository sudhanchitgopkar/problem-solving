class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return backtrack(new int [10], root);
    } //pseudoPalindromicPaths

    private int backtrack(int [] path, TreeNode curr) {
        //process this element
        path[curr.val]++;
        
        //if leaf node
        if (curr.left == null && curr.right == null) {
            if (isValid(path)) {
                path[curr.val]--;
                return 1;
            } else {
                path[curr.val]--;
                return 0;
            } //if
        } //if
        
        //try each child if possible
        int l = curr.left == null ? 0 : 
                backtrack(path, curr.left);
        int r = curr.right == null ? 0 : 
                backtrack(path, curr.right);
        //un-process this element
        path[curr.val]--;
        
        //return total num of solns
        return l + r;
    } //backtrack

    private boolean isValid(int [] path) {
        int numOdd = 0;
        for (int val : path) {
            numOdd += val % 2 == 0 ? 0 : 1;
            //palindromes can have at most 1 val w odd freq
            if (numOdd > 1) return false;
        } //for
        return true;
    } //valid
} //Sol
