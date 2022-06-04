class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int lMax = 0, gMax = 0;
        HashMap <Character, Integer> h = new HashMap <Character, Integer> ();
        
        for (int r = 0; r < s.length(); r++) {
            if (!h.containsKey(s.charAt(r)) || h.get(s.charAt(r)) < l) {
                h.put(s.charAt(r),r);
            } else {
                l = h.get(s.charAt(r)) + 1;
                h.put(s.charAt(r),r);
            } //if
            
            lMax = r - l + 1;
            
            if (gMax < lMax) gMax = lMax;
        } //for
        
        return gMax;
    } //lenLongestSubstring
} //Solution
