class Solution {
    public String breakPalindrome(String p) {
        int n = p.length();
        if (n == 1) return "";
        
        boolean swapped = false;
        StringBuilder s = new StringBuilder(p);
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) != 'a' && i != n/2 && !swapped) {
                s.setCharAt(i,'a');
                swapped = true;
            } //if
        } //for
        
        return swapped ? s.toString() : p.substring(0,n-1) + "b";
    } //break
} //Sol