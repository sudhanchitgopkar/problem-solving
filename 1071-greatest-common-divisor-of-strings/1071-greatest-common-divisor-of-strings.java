class Solution {
    public String gcdOfStrings(String s1, String s2) {
       int n = s1.length(), m = s2.length();
       if (s1.equals(s2)) return s1;

        String divisor = n < m ? s1 : s2;

        while (divisor.length() > 0) {
            if (isGCD(divisor, s1) && isGCD(divisor, s2)) 
                return divisor;
            else divisor = divisor.substring(0,divisor.length()-1);
        } //while

        return divisor;
    } //gcd

    private boolean isGCD (String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (m % n != 0) return false;

        for (int i = 0; i < m/n; i++) {
            if (!s2.substring(i * n, i * n + n).equals(s1)) return false;
        } //for

        return true;
    } //isGCD
} //sol