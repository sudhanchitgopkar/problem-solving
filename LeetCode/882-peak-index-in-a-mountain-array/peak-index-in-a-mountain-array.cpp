class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int l = 0, n = arr.size(), r = n - 1;

        while (l < r) {
            int m = l + (r - l)/2;
            if (m == 0) {
                l = ++m;
            } else if (m == n - 1) {
                r = --m;
            } //if

            if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                return m;
            } else if (arr[m] < arr[m + 1]) {
                l = ++m;
            } else {
                r = --m;
            } //if
        } //while

        return l;
    } //peakIndex
};