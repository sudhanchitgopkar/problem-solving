class Solution {
    public String largestGoodInteger(String num) {
        int l = 0;
        char sol = ' ';

        while (l + 2 < num.length()) {
            if (num.charAt(l) == num.charAt(l + 1) &&
                num.charAt(l + 1) == num.charAt(l + 2) &&
                (sol == ' ' || num.charAt(l) > sol)) {
                    sol = num.charAt(l);
            } //if
            ++l;
        } //while

        StringBuilder sb = new StringBuilder();
        return sol == ' ' ? sb.toString(): sb.append(sol).append(sol).append(sol).toString();
    } //largestGood
} //Sol