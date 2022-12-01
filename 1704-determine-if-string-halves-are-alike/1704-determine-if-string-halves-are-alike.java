class Solution {
    public boolean halvesAreAlike(String s) {
        int diffs = 0;
        for (int i = 0; i < s.length(); i++)
            if (i < s.length()/2 && isVowel(s.charAt(i))) diffs++;
            else if (isVowel(s.charAt(i))) diffs--;
        return diffs == 0;
    } //halves
    
    private boolean isVowel(char c) {
        return 
            c == 'a' || c == 'A' || 
            c == 'e' || c == 'E' || 
            c == 'i' || c == 'I' || 
            c == 'o' || c == 'O' || 
            c == 'u' || c == 'U';
    } //isVowel
}