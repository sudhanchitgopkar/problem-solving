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
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue <TreeNode*> q;
        vector<vector<int>> sol;

        if (root == nullptr) return sol;
        q.push(root);

        while (!q.empty()) {
            vector<int> lvl;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode* curr = q.front();
                lvl.push_back(curr->val);
                q.pop();

                if (curr->left != nullptr) {
                    q.push(curr->left);
                } //if

                if (curr->right != nullptr) {
                    q.push(curr->right);
                } //if
            } //for

            sol.push_back(lvl);
        } //while

        return sol;
    } //levelOrder
};