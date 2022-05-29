class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
        int l = 0, r = s.length()-1;
        
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--)) return false;
        
        return true;
    } //isPalindrome
} //Solution

/*
raceacar
r=r 0
a=a 1
c=c 2
e=a 3

*/