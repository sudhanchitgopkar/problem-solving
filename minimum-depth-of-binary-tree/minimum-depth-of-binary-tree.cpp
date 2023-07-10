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
    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        return dfs(root, 1);
    } //minDepth

    int dfs(TreeNode* root, int depth) {
        if (root->left == nullptr && root->right == nullptr) return depth;

        int sol = INT_MAX;
        if (root->left != nullptr) {
            sol = min(sol, dfs(root->left, 1 + depth));
        }//if

        if (root->right != nullptr) {
            sol = min(sol, dfs(root->right, 1 + depth));
        } //if

        return sol;
    } //dfs
};