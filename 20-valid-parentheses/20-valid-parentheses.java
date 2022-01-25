class Solution {
    public boolean isValid(String s) {
        Stack <Character> c = new Stack <Character> ();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') c.push('}');
            else if (s.charAt(i) == '[') c.push(']');
            else if (s.charAt(i) == '(') c.push(')');
            
            if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')' )
                if (c.isEmpty()) return false;
                else if (s.charAt(i) != c.pop()) return false; 
        } //for
        
        if (c.isEmpty()) return true;
        else return false;
    } //isValid
} //Solution