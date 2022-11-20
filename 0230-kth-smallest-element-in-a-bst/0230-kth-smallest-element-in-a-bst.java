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
     public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> inorder = new Stack<TreeNode>();
        int count = 0;
        inorder.push(root);
         
        while (!inorder.isEmpty()) {
            if (root != null) {
                inorder.push(root);
                root = root.left;   
            } else {
                root = inorder.pop();
                if (++count == k) return root.val; 
                else root = root.right;
            } //if
        } //while
     
     return -1;
    }
}