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
        build_graph(root);
        bfs(target->val, k);
        return sol;
    } //distK

    void build_graph(TreeNode* root) {
        queue <TreeNode*> q;

        q.push(root);

        while(!q.empty()) {
            TreeNode* curr = q.front();
            q.pop();

            if (curr->left != nullptr) {
                adj[curr->val].push_back(curr->left->val);
                adj[curr->left->val].push_back(curr->val);
                q.push(curr->left);
            } //if

            if (curr->right != nullptr) {
                adj[curr->val].push_back(curr->right->val);
                adj[curr->right->val].push_back(curr->val);
                q.push(curr->right);
            } //if
        } //while
    } //build_graph

    void bfs(int target, int k) {
        queue <int> q;
        unordered_set<int> seen;
        q.push(target);

        while (k != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.front();
                seen.insert(q.front());
                q.pop();

                for (int next : adj[curr]) {
                    if (!seen.count(next)) {
                        q.push(next);
                    } //if
                } //for
            } //for
            --k;
        } //while
        
        while (!q.empty()) {
            sol.push_back(q.front());
            q.pop();
        } //while
    } //bfs
};