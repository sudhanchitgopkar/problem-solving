class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int lMax = 0, gMax = 0, maxFreq = 0;
        int [] freq = new int [26];
        
        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r)  - 'A']++;
            if (freq[s.charAt(r)  - 'A'] > maxFreq) maxFreq = freq[s.charAt(r)  - 'A'];
            
            if (r - l + 1 - maxFreq <= k) {
                //string is valid
            } else {
                while (r - l + 1 - maxFreq > k) {
                    freq[s.charAt(l)-'A']--;
                    l++;
                    maxFreq = update(freq);
                } //while
            } //if
            
            lMax = r - l + 1;
            
            if (gMax < lMax) gMax = lMax;
        } //for
        
        return gMax;
    } //charReplacement
    
    public int update (int [] freq) {
        int max = freq[0];
        
        for (int f : freq)
            if (max < f) max = f;
        
        return max;
    } //update
} //Sol