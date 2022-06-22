class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue <Integer> ();
        
        for (int n : nums) {
            pq.add(n);    
            if (pq.size() > k) pq.poll();                
        } //for
        
        return pq.peek();
    } //findKthLargest
} //Sol