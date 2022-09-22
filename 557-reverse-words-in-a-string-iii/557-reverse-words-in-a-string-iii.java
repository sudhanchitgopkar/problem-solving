class Solution {
    public String reverseWords(String s) {
        int l = 0, r = 0;
        String sol = "";
        
        while (l < s.length()) {
            while (r < s.length() && s.charAt(r) != ' ') r++;
            int temp = r - 1;
            while (temp >= 0 && temp >= l) sol += s.charAt(temp--);
            sol += " ";
            l = ++r;
        } //while
       
        return sol.substring(0,sol.length()-1);
    } //revWords
} //Sol