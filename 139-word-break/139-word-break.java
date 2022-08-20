class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet <String> dict = new HashSet <String> (wordDict);
        boolean [] dp = new boolean [s.length()+1];
        
        dp[s.length()] = true;
        
        for (int l = s.length()-1; l >= 0; l--) {
            for (String word : wordDict) {
               if (l + word.length() <= s.length() && 
                   dict.contains(s.substring(l,l+word.length()))) {
                   dp[l] = dp[l+word.length()];
                   if (dp[l]) break;
               } //if
            } //for
        } //for
        
        return dp[0];
    } //wordBreak
} //Sol