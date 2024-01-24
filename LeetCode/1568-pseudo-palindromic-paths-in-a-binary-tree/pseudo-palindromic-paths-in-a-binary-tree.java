/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return backtrack(new int [10], root);
    } //pseudoPalindromicPaths

    private int backtrack(int [] path, TreeNode curr) {
        path[curr.val]++;

        if (curr.left == null && curr.right == null) {
            if (isValid(path)) {
                path[curr.val]--;
                return 1;
            } else {
                path[curr.val]--;
                return 0;
            } //if
        } //if

        int l = curr.left == null ? 0 : backtrack(path, curr.left);
        int r = curr.right == null ? 0 : backtrack(path, curr.right);
        path[curr.val]--;

        return l + r;
    } //backtrack

    private boolean isValid(int [] path) {
        int numOdd = 0;
        for (int val : path) {
            numOdd += val % 2 == 0 ? 0 : 1;
            if (numOdd > 1) return false;
        } //for
        return true;
    } //valid
} //Sol