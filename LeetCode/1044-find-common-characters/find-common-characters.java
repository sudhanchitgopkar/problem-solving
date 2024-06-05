class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int [][] freq = new int [n][26];
        List<String> sol = new ArrayList <> ();

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                freq[i][c - 'a']++;
            } //for
        } //for

        for (int i = 0; i < 26; i++) {
            int minFreq = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minFreq = Math.min(minFreq, freq[j][i]);
            } //for
            
            for (int j = 0; j < minFreq; j++) {
                sol.add("" + (char) (97 + i));
            } //for
        } //for

        return sol;
    } //commonChars
} //Sol