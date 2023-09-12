class Solution {
    public int minDeletions(String s) {
       int [] freq = new int [26];
       int [] buckets = new int [s.length() + 1];
       int sol = 0;

       for (char c : s.toCharArray()) {
           freq[c - 'a']++;
       } //for

       for (int i = 0; i < 26; i++) {
           if (freq[i] > 0) {
               buckets[freq[i]]++;
           } //if
       } //for

       for (int i = 1; i < buckets.length; i++) {
           while (buckets[i] > 1) {
               int closestEmpty = searchEmpty(i, buckets);
               buckets[closestEmpty] = closestEmpty == 0 ? 0 : 1;
               buckets[i]--;
               sol += i - closestEmpty;
           } //while
       } //for

        return sol;
    } //minDeletions

    private int searchEmpty(int i, int [] buckets) {
        for (int j = i - 1; j >= 0; j--) {
            if (buckets[j] == 0) return j;
        } //for
        return 0;
    } //searchEmpty
} //Sol