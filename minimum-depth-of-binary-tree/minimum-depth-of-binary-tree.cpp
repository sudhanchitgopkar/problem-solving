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
        queue <TreeNode*> q;
        int sol = 1;

        if (root == nullptr) return 0;
        q.push(root);

        while (!q.empty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode* curr = q.front();
                q.pop();

                if (curr->left == nullptr && curr->right == nullptr) {
                    return sol;
                } else {
                    if (curr->left != nullptr) q.push(curr->left);
                    if (curr->right != nullptr) q.push(curr->right);
                } //if
            } //for

            sol++;
        } //while  

        return -1; //should be unreachable 
    } //minDepth
};