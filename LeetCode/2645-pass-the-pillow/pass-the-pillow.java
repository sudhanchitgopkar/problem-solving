class Solution {
    public int passThePillow(int n, int time) {
       int rem = time % (n - 1), div = time / (n - 1);

       if (div % 2 == 0) return rem + 1;
       return n - rem; 
    } //pass
} //Sol

/*
n = 3
time = 8
1-2-3-2-1-2-3-2-1
0 1 2 3 4 5 6 7 8
*/