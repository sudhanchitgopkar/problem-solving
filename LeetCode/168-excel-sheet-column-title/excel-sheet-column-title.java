class Solution {
    public String convertToTitle(int num) {
        StringBuilder sol = new StringBuilder();
        
        while (--num >= 0) {
            sol.insert(0, (char)((num % 26) + ('A')));
            num /= 26;
        } //while

        return sol.toString();
    } //convert
} //Sol