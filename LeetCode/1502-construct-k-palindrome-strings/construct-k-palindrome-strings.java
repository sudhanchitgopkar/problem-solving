class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (k > n) return false;
        if (k == n) return true;

        int [] freq = new int [26];
        int numPairs = 0, numOnes = 0;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        } //for

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                System.out.println(((char)('a' + i)) + "\t" + freq[i]);
            numPairs += freq[i]/2;
            numOnes += freq[i] % 2;
        } //for

        if (numPairs >= k) {
            return numOnes <= k;
        } else {
            if (numOnes >= (k - numPairs) && numOnes <= k) {
                return true;
            } else if (numOnes > (k - numPairs)) {
                return false;
            } else {
                int numOpen = (k - numPairs - numOnes);
                int numEligible = (k - numOnes);
                return numEligible >= numOpen;
            } //if
        } //if
    } //canConstruct
} //Sol