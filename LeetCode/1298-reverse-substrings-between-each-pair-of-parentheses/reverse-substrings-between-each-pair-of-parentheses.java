class Solution {
    public String reverseParentheses(String s) {
        List<int []> parens = new ArrayList <> ();
        Stack<Integer> openParen = new Stack <> ();

        //find all sets of parens
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openParen.push(i);
            if (s.charAt(i) == ')') parens.add(new int [] {openParen.pop(), i});
        } //for
        
        //reverse what's inside them
        for (int [] paren : parens) {
            s = boundedRev(s, paren[0], paren[1]);
        } //for

        //remove all the parens
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                s = s.substring(0, i) + s.substring(i-- + 1);
            } //if
        } //for

        return s;
    } //revParen

    private String boundedRev(String s, int l, int r) {
        //reverses s between indices [l, r]
        String pre = s.substring(0, l);
        String suf = s.substring(r + 1);
        String rev = new StringBuilder(s.substring(l, r + 1)).reverse().toString();
        return pre + rev + suf;
    } //boundedRev
} //Sol