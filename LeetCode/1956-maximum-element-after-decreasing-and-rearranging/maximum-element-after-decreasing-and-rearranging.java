class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length, minViable = 1;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] < minViable) return minViable;
            else if (arr[i] > minViable) ++minViable;
        } //for

        return Math.min(n, minViable);
    } //maximumElementAfterDecrementingAndRearranging
} //Sol