class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    } //findKthLargest
    
    private int quickSelect (int [] nums, int l, int r, int k) {
        int pivot = l;
        
        for (int curr = l; curr < r; curr++) 
            if (nums[curr] <= nums[r]) 
                swap(nums,curr,pivot++);
        
        swap(nums,pivot,r);
        
        if (pivot == k) return nums[pivot];
        else if (pivot > k) return quickSelect(nums,0,pivot-1,k);
        return quickSelect(nums,pivot+1,nums.length-1,k);
    } //quickSelect
    
    private void swap (int [] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    } //swap   
} //Sol