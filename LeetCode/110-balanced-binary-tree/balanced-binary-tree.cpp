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
    bool balanced = true;
    bool isBalanced(TreeNode* root) {
        len(root);
        return balanced;
    } //isBalanced

    int len(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        } //if

        int ll = len(root->left), lr = len(root->right);
        if (abs(ll - lr) > 1) {
            balanced = false;
        } //if

        return max(ll, lr) + 1;
    } //len
};