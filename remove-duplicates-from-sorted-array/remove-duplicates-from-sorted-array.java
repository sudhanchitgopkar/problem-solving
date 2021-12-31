class Solution {
    public int removeDuplicates(int[] nums) {
        int numDuplicates = 0;
        int curr = 0;
        
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i-1]) {
                numDuplicates++;
                nums[i] = nums[0]-1;
            } //if
        } //for
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[0]-1) {
              nums[curr] = nums[i];
                curr++;
            } //if 
        } //for
        
        return nums.length-numDuplicates;
    } //removeDuplicates
} //Solution