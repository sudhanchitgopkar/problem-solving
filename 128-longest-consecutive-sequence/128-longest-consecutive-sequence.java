class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        
        HashSet <Integer> h = new HashSet <Integer> ();
        int lMax = 1, gMax = 1;
        for (int n : nums)
            h.add(n);
        
        for (int n : nums) {
            if (!h.contains(n-1)) {
                lMax = 1;
                while (h.contains(++n))
                    lMax++;
            }
            if (lMax > gMax) gMax = lMax;
        } //for
        
        return gMax;
    } //longestCon
} //Sol