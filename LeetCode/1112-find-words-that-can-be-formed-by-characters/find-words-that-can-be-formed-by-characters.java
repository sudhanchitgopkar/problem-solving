class Solution {
    public int countCharacters(String[] words, String chars) {
       int sol = 0;
       int [] freq = new int [26];
       for (char c : chars.toCharArray()) freq[c - 'a']++;

       for (String word : words) {
           boolean poss = true;
           int [] wfreq = new int [26];
           for (char c : word.toCharArray()) {
               if (++wfreq[c - 'a'] > freq[c - 'a']) {
                   poss = false;
                   break;
               } //if
           } //for

           if (poss) sol += word.length();
       } //for

       return sol;
    } //countChars
} //Sol