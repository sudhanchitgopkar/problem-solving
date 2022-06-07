class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> s = new Stack <Integer> ();
        int n1 = 0, n2 = 0;
        
        for (String t : tokens) {
            if (t.equals("+")) {
                n1 = s.pop();
                n2 = s.pop();
                s.push(n2 + n1);
            } else if (t.equals("-")) {
                n1 = s.pop();
                n2 = s.pop();
                s.push(n2 - n1);
            } else if (t.equals("*")) {
                n1 = s.pop();
                n2 = s.pop();
                s.push(n2 * n1);
            } else if (t.equals("/")) {
                n1 = s.pop();
                n2 = s.pop();
                s.push(n2 / n1);
            } else {
                s.push(Integer.parseInt(t));
            } //if
        } //for
        
        int sol = s.pop();
        return sol;
    } //evalRPN
} //Sol