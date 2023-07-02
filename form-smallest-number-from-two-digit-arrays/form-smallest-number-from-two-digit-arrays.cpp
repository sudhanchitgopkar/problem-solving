class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        int m1 {INT_MAX}, m2 {INT_MAX}, m3 {INT_MAX};
        
        unordered_set<int> s1 (nums1.begin(), nums1.end());

        for (int num : nums1) {
            m1 = min(m1, num);
        } //for

        for (int num : nums2) {
            if (s1.count(num) != 0) m3 = min(m3, num);
            m2 = min(m2, num);
        } //for

        if (m1 == m2) return m1;
        return min(m3, m1 < m2 ? (m1 * 10) + m2 : (m2 * 10) + m1);
    } //min
};