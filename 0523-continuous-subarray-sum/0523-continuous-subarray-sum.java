class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //init vars
        Map <Integer, Integer> seenMods = new HashMap <> ();
        int [] sum = new int [nums.length];
        
       //put 0 @ -1 to account for any 0 mod vals after the 0th index
        seenMods.put(0,-1);  
        
        //put first val in sum & mods
        sum[0] = nums[0];
        if (sum[0] % k != 0) seenMods.put(sum[0] % k,0); 
        
        
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i-1]; //calc next index sum
            
            //check if mod has been seen at a distance of 2+
            if (i - seenMods.getOrDefault(sum[i] % k,i) >= 2) 
                return true;
            else if (!seenMods.containsKey(sum[i] % k))
                seenMods.put(sum[i] % k,i);
        } //for
        
        return false;
    }
}