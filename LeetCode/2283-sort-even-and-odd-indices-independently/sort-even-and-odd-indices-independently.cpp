class Solution {
public:
    vector<int> sortEvenOdd(vector<int>& nums) {
        int n = nums.size();
        vector<int> even, odd;

        for (int i = 0; i < n; i+= 2) {
            even.push_back(nums[i]);
        } //for

        for (int i = 1; i < n; i += 2) {
            odd.push_back(nums[i]);
        } //for

        int o = odd.size() - 1, e = 0;

        sort(even.begin(), even.end());
        sort(odd.begin(), odd.end());

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even[e++];
            } else {
                nums[i] = odd[o--];
            } //if
        } //for

        return nums;
    } //sortEvenOdd
};