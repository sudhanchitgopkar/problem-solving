class Solution {
public:
    bool searchMatrix(vector<vector<int>>& mat, int target) {
        int m = mat.size(), n = mat[0].size();
        int row = searchRow(0, m - 1, target, mat);
        if (row == -1) return false;
        
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (mat[row][m] == target) {
                return true;
            } else if (mat[row][m] < target) {
                l = ++m;
            } else {
                r = --m;
            } //if
        } //while

        return false;
    } //search

    int searchRow(int l, int r, int target, vector<vector<int>>& mat) {
        while (l <= r) {
            int m = l + (r - l)/2;

            if (mat[m][0] <= target && mat[m][mat[0].size() - 1] >= target) {
                return m;
            } else if (mat[m][0] > target) {
                r = --m;
            } else {
                l = ++m;
            } //if
        } //while

        return -1;
    } //search
};