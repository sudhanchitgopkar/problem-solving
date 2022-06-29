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
        recurse(root,root.val);
        return sol;
    } //goodNodes
    
    private int recurse (TreeNode root, int max) {
        if (root == null) return max;
        
        if (root.val >= max) {
            max = root.val;
            sol++;
        } //if
        
        recurse(root.left,max);
        recurse(root.right,max);
        
        return max;
    } //recurse
} //Sol