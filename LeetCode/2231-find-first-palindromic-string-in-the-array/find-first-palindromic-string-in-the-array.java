class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) if (isP(word)) return word;
        return "";
    } //firstP

    private boolean isP(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        } //while
        return true;
    } //isP
} //Sol