class Solution {
    public String reverseWords(String s) {
        int l = 0, r = 0;
        String sol = "";
        
        while (l < s.length()) {
            while (r < s.length() && s.charAt(r) != ' ') r++;
            sol += getRev(s,"",l,r-1) + " ";
            l = ++r;
        } //while
       
        return sol.substring(0,sol.length()-1);
    } //revWords
    
    private String getRev (String s, String rev, int l, int r) {
        if (l > r) return rev;
        rev += s.charAt(r);
        return getRev(s,rev,l,r-1);
    } //getRev
}