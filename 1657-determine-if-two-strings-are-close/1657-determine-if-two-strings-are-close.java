class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int [] freqW1 = new int [26], freqW2 = new int [26];
        
        for (char c : word1.toCharArray()) freqW1[c-'a']++;
        for (char c : word2.toCharArray()) freqW2[c-'a']++;
        
        for (int i = 0; i < 26; i++) {
            if (freqW1[i] == 0 && freqW2[i] != 0) return false;
            else if (freqW1[i] != 0 && freqW2[i] == 0) return false;
        } //for
        
        Arrays.sort(freqW1);
        Arrays.sort(freqW2);
        
        for (int i = 0; i < 26; i++) {
            if (freqW1[i] != freqW2[i]) return false;
        }
        
        return true;
    }
}