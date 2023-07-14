class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        int n = arr.size();
        vector<int> sums (n);

        sums[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + arr[i];
        } //for

        if (sums[n - 1] % 3 != 0) {
            return false;
        } //if

        int target = sums[n - 1] / 3, count = 0;

        for (int i = 0; i < n; i++) {
            if (sums[i] == target) {
                target += sums[n - 1] / 3;
                count++;
            } //if
        } //for
       
        return count >= 3;
    } //canThreePartsEqualSum
};