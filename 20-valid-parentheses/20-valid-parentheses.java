class Solution {
    public boolean isValid(String s) {
        Stack <Character> p = new Stack <Character> ();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') p.push(')');
            else if (s.charAt(i) == '{') p.push('}');
            else if (s.charAt(i) == '[') p.push(']');
            
            if (s.charAt(i) == ')'
               || s.charAt(i) == '}'
               || s.charAt(i) == ']')
                if (p.empty() || p.peek() != s.charAt(i)) return false;
                else p.pop();
        } //for
        
        if (p.empty()) return true;
        else return false;
    } //isValid
} //Solution