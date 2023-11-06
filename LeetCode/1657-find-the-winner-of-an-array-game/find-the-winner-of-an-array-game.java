class Solution {
    public int getWinner(int[] arr, int k) {
        int max = 0, n = arr.length;
        for (int val : arr) {
            max = max >= val ? max : val; 
        } //for

        int streak = 0, curr = arr[0], i = 1;
        while (i < n) {
            if (curr == max) {
                return curr;
            } else if (arr[i++] > curr) {
                streak = 1;
                curr = arr[i - 1];
            } else {
                if (++streak == k) return curr;
            } //if
            if (streak == k) return curr;
        } //while

        return curr;
    } //getWinner
} //Sol