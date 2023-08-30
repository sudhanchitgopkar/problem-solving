class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        long long sol = 0;
        int n = nums.size(), cap = nums[n - 1];

        for (int i = nums.size() - 2; i >= 0; i--) {
            if (nums[i] > cap) {
                if (nums[i] % cap == 0) {
                    sol += nums[i]/cap - 1;
                } else {
                    sol += nums[i]/cap;
                    cap = nums[i]/(nums[i]/cap + 1);
                } //if
            } else if (nums[i] < cap) {
                cap = nums[i];
            } //if
        } //for
        
        return sol;
    } //minReplacement
};