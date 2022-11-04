class Solution {
    public String reverseVowels(String s) {
        int li = 0, ri = s.length() - 1;
        
        while (li < ri) {
            char l = s.charAt(li), r = s.charAt(ri);
            if (!isVowel(l)) li++;
            if (!isVowel(r)) ri--;
            if (isVowel(l) && isVowel(r)) s = swap(s,li++,ri--,l,r);
        }
        
        return s;
    } //reverseVowels
    
    private String swap (String s, int li, int ri, char l, char r) {
        return s.substring(0,li) + r + s.substring(li+1,ri) + l + s.substring(ri+1); 
    }
    
    private boolean isVowel(char c) {
       return 
           c == 'a' ||
           c == 'e' ||
           c == 'i' || 
           c == 'o' || 
           c == 'u' ||
           c == 'A' ||
           c == 'E' ||
           c == 'I' || 
           c == 'O' || 
           c == 'U';
    } //isVowel
} //Sol