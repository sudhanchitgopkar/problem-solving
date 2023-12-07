class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.isDigit(num.charAt(i)) &&
                Integer.parseInt(num.substring(i, i+1)) % 2 != 0)
                    return num.substring(0, i + 1);
        } //for
        return "";
    } //largestOdd
} //Sol