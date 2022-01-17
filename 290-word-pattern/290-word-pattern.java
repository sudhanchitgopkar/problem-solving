class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap <Character, String> h = new HashMap <Character, String> ();
        int ptr = 0, wordStart = 0;
        s += " ";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (ptr >= pattern.length())
                    return false;
                
                if (!h.containsKey(pattern.charAt(ptr)) && 
                    !h.containsValue(s.substring (wordStart, i)))
                    h.put(pattern.charAt(ptr), s.substring (wordStart, i));
                 else if (!h.containsKey(pattern.charAt(ptr))) 
                    return false;
                else if (!h.get(pattern.charAt(ptr)).equals(s.substring (wordStart, i)))
                    return false;
                ptr++; wordStart = i + 1;
                } //if
        } //for
        
        if (ptr != pattern.length())
            return false;
        return true;
    } //wordPattern
} //Solution