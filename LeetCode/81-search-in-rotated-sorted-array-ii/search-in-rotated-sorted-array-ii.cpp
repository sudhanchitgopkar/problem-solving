class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int n = nums.size(), l = 0, r = n - 1;
        if (n == 1) return target == nums[0];

        while (l <= r) {
            if (nums[l] == target || nums[r] == target) return true;
            while (l < n && nums[l] == nums[r]) ++l;
            if (l > r) return false;

            int m = l + (r - l)/2;
            if (nums[m] == target) {
                return true;
            } //if
            
            if (nums[m] == target)
                return m;
            else if (nums[l] <= nums[m] && 
                     nums[l] <= target && 
                     nums[m] >= target)
                r = m-1;
            else if (nums[l] <= nums[m])
                l = m+1;
            else if (nums[m] <= nums[r] && 
                     nums[m] <= target && 
                     nums[r] >= target)
                l = m+1;
            else
                r = m-1;
        } //while

        return false;
    } //search
};