class Solution {
    public String longestPalindrome(String s) {
        int max = 0, maxl = 0, maxr = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l-1 >= 0 && s.charAt(l-1) == s.charAt(l)) l--;
            while (r+1 < s.length() && s.charAt(r+1) == s.charAt(r)) r++;
            
            if (r - l + 1 > max) {
                max = r - l + 1;
                maxl = l;
                maxr = r;
            } //if
            
            while (--l >= 0 && ++r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) break;
                else if (r - l + 1 > max) {
                    max = r - l + 1;
                    maxl = l;
                    maxr = r;
                } //if
            }//while
            
        } //for
        
        return s.substring(maxl,maxr+1);
    } //longestPalindrome
    
} //Solution