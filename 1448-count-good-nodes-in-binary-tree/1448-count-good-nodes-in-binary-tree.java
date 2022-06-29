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
    int sol = 0;
    
    public int goodNodes(TreeNode root) {
        recurse(root,Integer.MIN_VALUE);
        return sol;
    } //goodNodes
    
    private int recurse (TreeNode root, int maxSoFar) {
        if (root == null) return maxSoFar;
        if (root.val >= maxSoFar) {
            maxSoFar = root.val;
            sol++;
        } //if
        recurse(root.left,maxSoFar);
        recurse(root.right,maxSoFar);
        return maxSoFar;
    } //recurse
} //Sol