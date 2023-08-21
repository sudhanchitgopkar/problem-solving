class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;

       //try every substring
       /*
       for (int r = 0; r < s.length()/2; r++) {
            if (checkIterative(r, s)) {
                return true;
            } //if
       } //for
        */

        for (int i = 0; i < s.length()/2; i++) {
            if (s.length() % (i + 1) != 0) continue;
            String substr = s.substring(0, i + 1);
            if (check(substr, new StringBuilder (), s)) {
                return true;
            } //if
        } //for

       //if none have worked
       return false; 
    } //repeatedSubstringPattern

    private boolean checkIterative(int r, String s) {
        if (s.length() % (r + 1) != 0) return false;

        for (int i = r + 1; i < s.length(); i++) {
            char curr = s.charAt(i % (r + 1));
            if (curr != s.charAt(i)) return false;
        } //for     
        
        return true;
    } //checkIterative

    private boolean check(String substr, StringBuilder curr, String s) {
        if (curr.toString().equals(s)) return true;
        if (curr.length() > s.length()) return false;
        curr.append(substr);
        return check(substr, curr, s);
    } //check
} //Sol