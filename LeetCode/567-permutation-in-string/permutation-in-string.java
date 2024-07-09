class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int l = 0, r = 0;

        int [] s1Freq = new int [26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        } //for

        int [] windowFreq = new int [26];
        for (; r < s1.length(); r++) {
            windowFreq[s2.charAt(r) - 'a']++;
        } //for
        if (checkAna(s1Freq, windowFreq)) return true;
        debug(s1Freq, windowFreq);


        while (r < s2.length()) {
            windowFreq[s2.charAt(l++) - 'a']--;
            windowFreq[s2.charAt(r++) - 'a']++;
            if (checkAna(s1Freq, windowFreq)) return true;
        } //while

        return false;
    } //checkInclusion

    private boolean checkAna(int [] a, int [] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        } //for
        return true;
    } //checkAna    


    private void debug(int [] a, int [] b) {
        System.out.println("S1: " + Arrays.toString(a));
        System.out.println("WINDOW: " + Arrays.toString(b));
    }
} //Sol