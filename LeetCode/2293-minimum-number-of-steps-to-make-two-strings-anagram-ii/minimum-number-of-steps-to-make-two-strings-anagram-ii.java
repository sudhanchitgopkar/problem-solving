class Solution {
    public int minSteps(String s, String t) {
        int sol = 0;
        int [] sfreq = new int [26], tfreq = new int [26];

        for (char c : s.toCharArray()) sfreq[c - 'a']++;
        for (char c : t.toCharArray()) tfreq[c - 'a']++;

        for (int i = 0; i < 26; i++) {
            sol += Math.abs(sfreq[i] - tfreq[i]);
        } //for
        
        return sol;
    } //minSteps 
} //Sol