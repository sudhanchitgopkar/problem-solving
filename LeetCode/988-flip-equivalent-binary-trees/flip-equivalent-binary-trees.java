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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return can(root1, root2);
    } //flip

    public boolean can(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return r1 == null && r2 == null;
        } else if (r1.val != r2.val) {
            return false;
        } //if

        int samevals = 0;
        samevals = samevals ^ (r1.left == null ? -1 : r1.left.val);
        samevals = samevals ^ (r2.left == null ? -1 : r2.left.val);
        samevals = samevals ^ (r1.right == null ? -1 : r1.right.val);
        samevals = samevals ^ (r2.right == null ? -1 : r2.right.val);

        if (samevals != 0) {
            return false;
        } else {
            return (can(r1.left, r2.left) && can(r1.right, r2.right)) ||
                    (can (r1.right, r2.left) && can(r1.left, r2.right));
        } //if
    } //can
} //Sol