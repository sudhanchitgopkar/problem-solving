class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> mod (n, 0);
        unordered_map <int, int> freq;

        for (int i = 0; i < n; i++) {
            mod[i] = arr[i] % k;
            if (mod[i] < 0) mod[i] += k;
            freq[mod[i]]++;
        } //for

        for (int i = 0; i < k; i++) {
            if (i == 0) {
                if (freq[i] % 2 == 1) return false;
            } else if (freq[i] != freq[k - i]) {
                return false;
            } //if
        } //for

        return true;
    } //canArrange
};