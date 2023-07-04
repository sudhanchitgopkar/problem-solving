class Solution {
public:
    int differenceOfSum(vector<int>& nums) {
        long long sum = 0, digs = 0;

        for (int num : nums) {
            sum += num;
            digs += digitSum(num);
        } //for

        return abs(sum - digs);
    } //diffOfSum

    int digitSum(long long n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        } //while
        return sum;
    } //digitSum
};