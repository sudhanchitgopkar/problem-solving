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
    bool isCousins(TreeNode* root, int x, int y) {
        queue <TreeNode*> q;
        bool hasX = false, hasY = false;

        q.push(root);

        while (!q.empty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode* curr = q.front();
                q.pop();

                if (curr->left != nullptr && curr->right != nullptr) {
                    if (curr->left->val == x && curr->right->val == y)
                        return false;
                    if (curr->left->val == y && curr->right->val == x) 
                        return false;
                } //if

                if (curr->val == x) hasX = true;
                if (curr->val == y) hasY = true;

                if (curr->left != nullptr) q.push(curr->left);
                if (curr->right != nullptr) q.push(curr->right);
            } //for

            if (hasX && hasY) {
                return true;
            } else if (hasX || hasY) {
                return false;
            } //if
        } //while
        
        return false;
    } //isCousins
};