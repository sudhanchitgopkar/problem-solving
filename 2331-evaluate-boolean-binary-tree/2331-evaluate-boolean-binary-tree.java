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
    public boolean evaluateTree(TreeNode r) {
        return r.val < 2 ? r.val == 0 ? false : true : r.val == 2 ? evaluateTree(r.left) || evaluateTree(r.right)
            : evaluateTree(r.left) && evaluateTree(r.right);
        //if (r.val < 2) return r.val == 0 ? false : true;
       // return r.val == 2 ? evaluateTree(r.left) || evaluateTree(r.right)
         //   : evaluateTree(r.left) && evaluateTree(r.right);
    } //evalTree
} //Sol