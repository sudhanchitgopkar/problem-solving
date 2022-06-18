class Solution {
    public int findDuplicate(int[] nums) {  
        int slow = nums[nums[0]], fast = nums[nums[nums[0]]];
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } //while
        
        int head = nums[0];
        
        while (slow != head) {
            slow = nums[slow];
            head = nums[head];
        } //while
        
        return head;
    } //findDup
} //Sol