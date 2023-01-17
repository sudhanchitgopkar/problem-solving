class Solution {
    public int minFlipsMonoIncr(String s) {
       int n = s.length(), min = Integer.MAX_VALUE, flips = 0;
       char [] bits = s.toCharArray();
       int [] num0s = new int [n], num1s = new int [n];
       
       num0s[n-1] = bits[n-1] == '0' ? 1 : 0;
       num1s[0] = bits[0] == '1' ? 1 : 0;

       for (int i = 1; i < n; i++) 
           num1s[i] = num1s[i-1] + (bits[i] == '1' ? 1 : 0);

        for (int i = n - 2; i >= 0; i--)
            num0s[i] = num0s[i+1] + (bits[i] == '0' ? 1 : 0);
        
        for (int i = 0; i < n; i++) {
            int flip;
            if (bits[i] == 0) flip = num1s[i] + num0s[i] - 1;
            else flip = num1s[i] + num0s[i] - 1;
            min = Math.min(min,flip);
        } //for

        return min;
    } //minFlips
} //Sol
