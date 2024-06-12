class Solution {
    public void sortColors(int[] nums) {
        int [] freq = new int [3];
        int ni = 0;

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        } //for

        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                nums[ni++] = i;
            } //for
        } //for

    } // sortColors
} // Sol