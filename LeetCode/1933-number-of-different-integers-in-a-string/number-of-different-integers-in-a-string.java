class Solution {
    public int numDifferentIntegers(String word) {
        StringBuilder sb = new StringBuilder();
        HashSet <String> seen = new HashSet <> ();

        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c)) { 
                if (sb.length() > 0) {
                    while (sb.length() > 1 && sb.charAt(0) == '0') {
                        sb.delete(0, 1);
                    } //while
                    seen.add(sb.toString());
                    sb = new StringBuilder();
                } //if
            } else {
                sb.append(c);
            } //if
        } //for

        if (sb.length() > 0) {
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                        sb.delete(0, 1);
            } //while
            seen.add(sb.toString());
        } //if

        return seen.size();
    } //numDiffInt
} //Sol