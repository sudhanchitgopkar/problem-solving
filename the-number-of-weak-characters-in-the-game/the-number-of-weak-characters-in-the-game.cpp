class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& props) {
        int n = props.size(), maxSoFar = 0, sol = 0;
        int l = 0, r = 0;
        unordered_map <int, int> maxD;
        sort(props.begin(), props.end(), 
        [] (const vector<int>& a, const vector<int> & b) {
            return a[0] < b[0];
        });

        for (int i = n - 1; i >= 0; i--) {
            if (props[i][1] > maxSoFar) {
                maxSoFar = props[i][1];
            } //if
            maxD[props[i][0]] = maxSoFar;
        } //for

        while (r < n) {
            while (r < n && props[l][0] == props[r][0]) {
                r++;
            } //while
            if (r < n && maxD[props[r][0]] > props[l++][1]) sol++;
        } //for

        return sol;
    }//numWeak
};