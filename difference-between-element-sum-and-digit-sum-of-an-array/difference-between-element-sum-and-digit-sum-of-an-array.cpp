class Solution {
public:
    int differenceOfSum(vector<int>& nums) {
        int n = nums.size(), s = 0, ds = dsum(nums);
        
        for (int n : nums) s += n;

        return abs(ds - s);
    } //diffOfSum

    int dsum(vector<int>& nums) {
        int ds = 0;

        for (int n : nums) {
            while (n != 0) {
                ds += n % 10;
                n /= 10;
            } //while
        } //for

        return ds;
    } //dsum
};