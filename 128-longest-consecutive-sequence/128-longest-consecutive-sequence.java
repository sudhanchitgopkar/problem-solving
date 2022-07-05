class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> seen = new HashSet <Integer> ();
        int gMax = 0;
        
        for (int num : nums) seen.add(num);
        
        for (int num : nums) {
            int lMax = 1;          
            if (!seen.contains(num-1))
                while (seen.contains(++num)) lMax++;           
            gMax = Math.max(gMax, lMax);
        } //for
        
        return gMax;
    } //longestCon
} //Sol