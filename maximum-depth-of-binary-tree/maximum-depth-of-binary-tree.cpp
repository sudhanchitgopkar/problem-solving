/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        return dfs(root, 0);
    } //maxDepth

    int dfs(TreeNode* root, int depth) {
        if (root == NULL) return depth;
        return max(dfs(root->left, depth + 1), dfs(root->right, depth + 1));
    } //dfs
};