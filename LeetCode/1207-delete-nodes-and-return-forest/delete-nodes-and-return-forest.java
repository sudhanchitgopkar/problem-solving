class Solution {
    TreeNode [] nodeRefs;
    TreeNode [] parents;
    public List<TreeNode> delNodes(TreeNode root, int[] toDel) {
        List<TreeNode> sol = new ArrayList <> ();
        nodeRefs = new TreeNode [10001];
        parents = new TreeNode [10001];
        initRefs(root);

        sol.add(root);
        for (int del : toDel) {
            TreeNode curr = nodeRefs[del];
            TreeNode parent = parents[del];
            if (curr.left != null) sol.add(curr.left);
            if (curr.right != null) sol.add(curr.right);

            if (parent != null && parent.left == curr) parent.left = null;
            else if (parent != null) parent.right = null;
        } //for

        for (int del : toDel) {
            int delIndex = -1;
            for (int i = 0; i < sol.size(); i++) {
                if (sol.get(i).val == del) {
                    delIndex = i;
                    break;
                } //if
            } //for
            
            if (delIndex != -1) {
                sol.remove(delIndex);
            } //if
        } //for

        return sol;
    } //delNodes

    private void initRefs(TreeNode root) {
        nodeRefs[root.val] = root;
        if (root.left != null) {
            parents[root.left.val] = root;
            initRefs(root.left);
        } //if

        if (root.right != null) {
            parents[root.right.val] = root;
            initRefs(root.right);
        } //if
    } //initRefs
} //Sol