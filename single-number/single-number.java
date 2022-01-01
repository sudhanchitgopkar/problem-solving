class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];
    
        Set<Integer> s = new HashSet<Integer>();
	    for (int i: nums){
	    	if(!s.add(i)){
	    		s.remove(i);
	    	}
	    }
	    return s.iterator().next();
         
    } //singleNumber
} //Solution