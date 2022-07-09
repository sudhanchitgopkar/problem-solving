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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        
        if (root.val == key) {
            if (root.left == null && root.right == null) {        //leaf node
                root = null;
            } else if (root.left == null) { //one child
                return root.right;
            } else if (root.right == null) { //one child
               return root.left;
            } else {                                              //two children
                TreeNode replacement = root.right;
                while (replacement.left != null) replacement = replacement.left;
                root.val = replacement.val;
                root.right = deleteNode(root.right,replacement.val);
            } //else               
        } else if (root.val < key) {
            root.right = deleteNode(root.right,key);
        } else {
            root.left = deleteNode(root.left,key);    
        } //if
        
        return root;       
    } //deleteNode
} //Sol

/*
    5
  3   6
 2 4   7 

*/


                /*
                while (!(replacement.left == null && replacement.right == null)) {
                    if (replacement.left != null) replacement = replacement.left;
                    else replacement = replacement.right;
                } //while
                */