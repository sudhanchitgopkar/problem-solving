class Solution {
    public boolean isAnagram(String s, String t) {
        int [] freq = new int [26];
        if (s.length() != t.length()) return false;
        
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        } //for
        
        for (int f : freq)
            if (f != 0) return false;
        
        return true;
    } //isAnagram
} //Solution


/*
s = "abc" : incremented 
t = "ca" : decremented

26 unique letters
int array of length 26

 a b c d e
|0|0|0|0|0|...

*/