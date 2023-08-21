class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;

       //try every substring
       for (int r = 0; r < s.length()/2; r++) {
            if (checkIterative(r, s)) {
                return true;
            } //if
       } //for

       //if none have worked
       return false; 
    } //repeatedSubstringPattern

    private boolean checkIterative(int r, String s) {
        //if (r == s.length()) return false;
        if (s.length() % (r + 1) != 0) return false;

        for (int i = r + 1; i < s.length(); i++) {
            char curr = s.charAt(i % (r + 1));
            if (curr != s.charAt(i)) return false;
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