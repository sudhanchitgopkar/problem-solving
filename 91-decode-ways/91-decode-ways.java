public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] memo = new int [s.length() + 1];
        
        memo[0] = 1;
        if (s.charAt(0) == '0') memo[1] = 0;
        else memo[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (oneDigit >= 1 && oneDigit <= 9) 
               memo[i] += memo[i-1];  
            if (twoDigit >= 10 && twoDigit <= 26) 
                memo[i] += memo[i-2];
        } //for
        return memo[s.length()];
    } //numDecodings
} //Sol