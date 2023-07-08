class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        int n = weights.size();
        vector<int> pairWeights (n - 1, 0);

        for (int i = 0; i < n - 1; i++) {
            pairWeights[i] = weights[i] + weights[i + 1];
        } //for

        sort(pairWeights.begin(), pairWeights.end());

        long long maxSum = 0, minSum = 0;

        for (int i = 0; i < k - 1; i++) {
            minSum += (long long) pairWeights[i];
            maxSum += (long long) pairWeights[n - i - 2];
        } //for
        
        return maxSum - minSum;
    } //putMarbles
};