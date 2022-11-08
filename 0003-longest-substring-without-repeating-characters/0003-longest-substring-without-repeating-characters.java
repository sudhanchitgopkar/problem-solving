class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        
        HashMap <Character, Integer> charIdx = new HashMap <> ();
        int l = 0, max = 0; 
        charIdx.put(s.charAt(l),0);
        
        for (int r = 1; r < s.length(); r++) {
            if (charIdx.getOrDefault(s.charAt(r),-1) >= l) l = charIdx.get(s.charAt(r)) + 1;
            charIdx.put(s.charAt(r),r);
            max = r - l + 1 > max ? r - l + 1 : max;
        } //max
        
        return max;
    } //lenoflongestsubstr
} //Sol