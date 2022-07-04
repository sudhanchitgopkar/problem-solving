class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> vals = new PriorityQueue <Integer> ();
        
        for (int n : nums) {
            vals.offer(n);            
            if (vals.size() > k) vals.poll();
        } //for
        
        return vals.poll();
    } //findKthLargest
} //Sol