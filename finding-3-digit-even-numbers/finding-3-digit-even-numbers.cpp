class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        int n = digits.size();
        vector<int> sol;
        unordered_set <int> nums;

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int res = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (res % 2 == 0) nums.insert(res);
                } //for
            } //for
        } //for
        
        for (int num : nums) sol.push_back(num);
        sort(sol.begin(), sol.end());
        return sol;
    } //findEven
};