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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        
        if (root.val == subRoot.val && checkSame(root,subRoot)) return true;
        else return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    } //isSubtree
    
    private boolean checkSame (TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return (root == subRoot);
        
        if (root.val == subRoot.val) 
            return checkSame(root.left,subRoot.left) && checkSame(root.right,subRoot.right);
        
        return false;
    } //checkSame
} //Sol