class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
                sb.append(c);
            } //if
        } //for

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!Character.isUpperCase(c) && !Character.isLowerCase(c)) {
                sb.insert(i, c);
            } //if
        } //for

        return sb.toString();
    } //reverseOnlyLetters
} //Sol