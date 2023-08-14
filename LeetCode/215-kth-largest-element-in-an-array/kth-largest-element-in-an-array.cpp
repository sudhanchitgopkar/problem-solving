class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        vector<int> freq (2e4 + 1);
        int i = freq.size() - 1;

        for (int num : nums) {
            freq[num + 1e4]++;
        } //for

        for (i; i >= 0 && k > 0; i--) {
            k -= freq[i];
        } //for

        return i - 1e4 + 1;
    } //findKthLargest
};
