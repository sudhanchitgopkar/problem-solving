class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set <Character> sub = new HashSet <Character>();
        int l = 0; int r = 0; int gmax = 0;
        
        while (r < s.length()) {
            if (sub.contains(s.charAt(r)))
                sub.remove(s.charAt(l++));
            else 
                sub.add(s.charAt(r++));
            gmax = Math.max(gmax, sub.size());
        } //while
        
        return gmax;
        
    } //lenLongestSubstring
} //Solution
