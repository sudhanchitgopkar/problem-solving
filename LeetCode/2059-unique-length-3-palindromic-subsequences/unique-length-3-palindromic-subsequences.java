class Solution {
    public int countPalindromicSubsequence(String s) {
        int sol = 0, n = s.length();
        int [] first = new int [26], last = new int [26];
        boolean [] seen = new boolean [26];

        for (int i = 0; i < 26; i++) first[i] = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            first[c - 'a'] = first[c - 'a'] == -1 ? i : first[c - 'a'];
            last[c - 'a'] = i;
        } //for

        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) continue;
            Set <Character> btwn = new HashSet <> ();
            for (int i = first[c - 'a'] + 1; i < last[c - 'a']; i++) {
                btwn.add(s.charAt(i));
            } //for
            sol += btwn.size();
            seen[c - 'a'] = true;
        } //for

        return sol;
    } //countPalindromicSubseq
} //Sol
