class Solution {
public:
    vector<int> twoOutOfThree(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3) {
        unordered_set<int> n1(nums1.begin(), nums1.end()), 
            n2 (nums2.begin(), nums2.end()), 
            n3 (nums3.begin(), nums3.end());
        vector<int> sol;

        for (int val : n1) {
            if (n2.count(val) || n3.count(val)) {
                sol.push_back(val);
            } //if
        } //for
        
        for (int val : n2) {
            if (n1.count(val) == 0 && n3.count(val) > 0) {
                sol.push_back(val);
            } //if
        } //for

        return sol;
    } //twoOfThree
}; //Sol