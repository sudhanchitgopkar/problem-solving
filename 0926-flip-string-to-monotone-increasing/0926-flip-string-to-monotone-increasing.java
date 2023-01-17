class Solution {
    public int minFlipsMonoIncr(String s) {
       int sol = 0, num1s = 0;
       for (char c : s.toCharArray()) 
        if (c == '1') num1s++;
        else sol = Math.min(sol + 1, num1s);
       return sol;
    } //minFlips
} //Sol
