class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> openParen = new Stack <> ();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openParen.push(i);
            if (s.charAt(i) == ')') {
                s = boundedRev(s, openParen.pop(), i);
                i -= 2;
            } //if
        } //for
        
        return s;
    } //revParen

    private String boundedRev(String s, int l, int r) {
        //reverses s between indices (l, r), deleting l and r
        String pre = s.substring(0, l);
        String suf = s.substring(r + 1);
        String rev = new StringBuilder(s.substring(l + 1, r)).reverse().toString();
        return pre + rev + suf;
    } //boundedRev
} //Sol