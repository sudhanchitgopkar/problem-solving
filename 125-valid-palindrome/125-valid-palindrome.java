class Solution {
    public boolean isPalindrome(String s) {
        if (s.equals(" "))
            return true;
        
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        for (int i = 0; i < s.length()/2; i++) 
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    } //isPalindrome
    
} //Solution