class Solution {
    public int removeElement(int[] nums, int val) {
        int freq = 0;
        int shift = 0;
        
        for (int elem: nums)
            if(elem == val) freq++;
        
        if (freq == 0) return nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            nums[i - shift] = nums[i];
            
            if (nums[i] == val) shift++;
        } //for
        
        return nums.length - freq;
    } //removeElem
} //Solution