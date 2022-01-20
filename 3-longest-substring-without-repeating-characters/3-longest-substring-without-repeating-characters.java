class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap <Character, Integer> h = new HashMap <Character, Integer> ();
        int l = 0, r = 0;
        int lMax = 0, gMax = 0;
        
        while (r < s.length()) {
            if (h.containsKey(s.charAt(r))) {
                l = l < h.get(s.charAt(r)) + 1 ? h.get(s.charAt(r)) + 1 : l;
                h.remove(s.charAt(r));
            } //if
            h.put(s.charAt(r),r);
            
            lMax = ++r-l;
            gMax = lMax > gMax ? lMax : gMax;
        } //while
        
        return gMax;
    } //lenLongestSubstring
} //Solution
