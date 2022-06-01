class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, max = 0;
        HashMap <Character, Integer> h = new HashMap <Character, Integer> ();
        
        for (int i = 0; i < s.length(); i++) {
            if (!h.containsKey(s.charAt(i)) || h.get(s.charAt(i)) < l) {
                h.put(s.charAt(i), i);
            } else {
                l = h.get(s.charAt(i)) + 1;
                h.put(s.charAt(i),i);
            } //if
            if (i - l + 1 > max) max = i - l + 1;
        } //for
        
        return max;
    } //lenLongestSubstring
} //Solution
