class Solution {
    public String convertToTitle(int num) {
        String sol = "";
        
        while (--num >= 0) {
            char c = (char)((num % 26) + ('A'));
            //if (c == '@') c = 'Z';
            sol = c + sol;
            num /= 26;
        } //while

        return sol;
    } //convert
} //Sol