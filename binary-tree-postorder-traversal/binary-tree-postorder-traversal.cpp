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
    vector<int> sol;
    vector<int> postorderTraversal(TreeNode* root) {
        if (root == nullptr) return sol;

        postorderTraversal(root->left);
        postorderTraversal(root->right);
        
        sol.push_back(root->val);
        return sol;
    } //postOrder
};