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
    List<TreeNode> sols;
    public List<TreeNode> generateTrees(int n) {
        sols = new ArrayList <> ();

        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            boolean [] used = new boolean [n + 1];
            used[i] = true;
            dfs(root, used, new HashSet <String> ());
        } //for

        return sols;
    } //genTree

    private void dfs (TreeNode root, boolean [] used, HashSet<String> seen) {
        if (all(used)) {
            String s = getString(root);
            if (!seen.contains(s)) {
                sols.add(copy(root));
                seen.add(s);   
            } //if
            return;
        } //if

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                TreeNode next = new TreeNode (i);
                add(root, next);
                used[i] = true;
                dfs(root, used, seen);
                remove(root, next);
                used[i] = false;
            } //if
        } //for
    } //dfs

    private TreeNode copy(TreeNode root) {
        if (root == null) return null;
        TreeNode copied = new TreeNode(root.val);
        copied.left = copy(root.left);
        copied.right = copy(root.right);
        return copied;
    } //copy

    private boolean all(boolean [] used) {
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) return false;
        } //for
        return true;
    } //done

    private void add(TreeNode root, TreeNode newNode) {
        if (newNode.val > root.val && root.right == null) root.right = newNode;
        else if (newNode.val > root.val) add(root.right, newNode);
        else if (newNode.val < root.val && root.left == null) root.left = newNode;
        else if (newNode.val < root.val) add(root.left, newNode);
    } //add

    private void remove(TreeNode root, TreeNode toDel) {
        if (root.left == toDel) root.left = null;
        else if (root.right == toDel) root.right = null;
        else if (toDel.val < root.val) remove(root.left, toDel);
        else remove(root.right, toDel);
    } //del

    private String getString(TreeNode root) {
        StringBuilder s = new StringBuilder();
        Queue <TreeNode> q = new LinkedList <> ();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            s.append(curr.val + ",");
            if (curr.left == null) s.append("null,");
            else q.offer(curr.left);
            if (curr.right == null) s.append("null,");
            else q.offer(curr.right);
        } //while

        return s.toString();
    } //print
} //Sol