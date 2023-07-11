/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    unordered_map <int, vector<int>> adj; 
    vector<int> sol;  
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        build_graph(root, root);
        unordered_set<int> seen;
        dfs(target->val, 0, k, seen);
        return sol;
    } //distK

    void build_graph(TreeNode* curr, TreeNode* prev) {
        if (curr->val != prev->val) {
            adj[curr->val].push_back(prev->val);
        } //if

        if (curr->left != nullptr) {
            adj[curr->val].push_back(curr->left->val);
            build_graph(curr->left, curr);
        } //if

        if (curr->right != nullptr) {
            adj[curr->val].push_back(curr->right->val);
            build_graph(curr->right, curr);
        } //if
    } //build_graph

    void dfs(int curr, int dist, int k, unordered_set<int> seen) {
        if (dist == k) {
            sol.push_back(curr);
            return;
        } //if

        seen.insert(curr);

        for (int next : adj[curr]) {
            if (!seen.count(next)) {
                dfs(next, dist + 1, k, seen);
            } //if
        } //for
    } //dfs
};