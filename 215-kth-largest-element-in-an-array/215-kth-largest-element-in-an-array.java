class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    } //findKthLargest
    
    private int quickSelect (int [] nums, int l, int r, int k) {
        int pivot = l;
        for (int curr = l; curr < r; curr++) {
            if (nums[curr] <= nums[r]) {
                int temp = nums[curr];
                nums[curr] = nums[pivot];
                nums[pivot++] = temp;
            }
        } //for
        
        int temp = nums[pivot];
        nums[pivot] = nums[r];
        nums[r] = temp;
        
        if (pivot == k) return nums[pivot];
        else if (pivot > k) return quickSelect(nums,0,pivot-1,k);
        return quickSelect(nums,pivot+1,nums.length-1,k);
    } //quickSelect
    
} //Sol