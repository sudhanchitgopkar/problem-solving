class Solution {
    public boolean isValid(String s) {
        Stack <Character> paren = new Stack <Character> ();

        for (int i = 0; i < s.length(); i++) {            
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                paren.push(s.charAt(i));
            else {
                if (paren.isEmpty())
                    return false;
                if (s.charAt(i) == ')' && paren.pop() != '(')
                    return false;
                if (s.charAt(i) == '}' && paren.pop() != '{')
                    return false;
                if (s.charAt(i) == ']' && paren.pop() != '[')
                    return false;
            } //if

        } //for
        
        if (paren.isEmpty())
            return true;
        else
            return false;
        

        
    } //isValid
} //Solution