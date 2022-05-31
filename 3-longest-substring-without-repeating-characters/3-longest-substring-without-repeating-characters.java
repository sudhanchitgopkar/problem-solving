class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap <Character, Integer> h = new HashMap <Character, Integer> ();
        int lMax = 0, gMax = 0;
        int l =  0, r = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (!h.containsKey(s.charAt(i)) || h.get(s.charAt(i)) < l) {
                h.put(s.charAt(i),i);
                r = i;
                lMax = r - l + 1;
            } else {
                l = h.get(s.charAt(i))+1;
                h.put(s.charAt(i),i);
                r = i;
                lMax = r - l + 1;
            }
            if (gMax < lMax) gMax = lMax;
        } //for
                
        return gMax;
    } //lenLongestSubstring
} //Solution
