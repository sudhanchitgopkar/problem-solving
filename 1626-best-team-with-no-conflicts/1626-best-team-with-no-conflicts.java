class Solution {
   public int bestTeamScore(int[] scores, int[] ages) {
       int n = ages.length, sol = 0;
       int[][] player = new int[n][2];
       
       for (int i = 0; i < n; i++) {
           player[i][0] = ages[i];
           player[i][1] = scores[i];
       } //for

       Arrays.sort(player, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

       int[] dp = new int[n];
       dp[0] = player[0][1];

       for (int i = 1; i < n; i++) {
           dp[i] = player[i][1];
           for (int j = 0; j < i; j++) 
               if (player[j][1] <= player[i][1])
                   dp[i] = Math.max(dp[i], player[i][1]+dp[j]);
       } //for

       for (int val : dp) sol = val > sol ? val : sol;
       return sol;
   }//bestScore
} //Sol