class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();

        vector <int> pre (n), post (n), sol (n);
        pre[0] = nums[0];
        post[n - 1] = nums[n - 1];
        
        //populate prefix and postfix arrays
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] * pre[i - 1];
            post[n - i - 1] = nums[n - i - 1] * post[n - i]; 
        } //for

        //and use those to calculate product except self
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sol[i] = post[1];
            } else if (i == n - 1) {
                sol[i] = pre[n - 2];
            } else {
                sol[i] = pre[i - 1] * post[i + 1];
            } //if
        } //for  

        return sol;
    } //productExceptSelf
};