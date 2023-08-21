class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;

       //try every substring
       for (int l = 1; l <= s.length()/2; l++) {
            String substr = s.substring(0, l);
            if (check(substr, substr, s)) {
                return true;
            } //if
           //} //for
       } //for

       //if none have worked
       return false; 
    } //repeatedSubstringPattern

    private boolean checkIterative(String substr, String s) {
        if (substr.equals(s)) return false;

        for (int i = substr.length(); i < s.length(); s += substr.length()) {
            if (!s.substring(i, i + substr.length()).equals(substr)) return false;
        } //for     
        
        return true;
    } //checkIterative

    private boolean check(String substr, String curr, String s) {
        if (curr.equals(s)) return true;
        if (curr.length() > s.length()) return false;
        curr += substr;
        return check(substr, curr, s);
    } //check
} //Sol