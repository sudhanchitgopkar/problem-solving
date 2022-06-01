class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, maxLen = 0, maxCount = 0;
        int [] freq = new int [26];
        
        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(r) - 'A']);
            
            while (r - l + 1 - maxCount > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            } //while
            
            maxLen = Math.max(maxLen, r-l+1);
        } //for
        
        return maxLen;
    } //charReplacement
} //Sol