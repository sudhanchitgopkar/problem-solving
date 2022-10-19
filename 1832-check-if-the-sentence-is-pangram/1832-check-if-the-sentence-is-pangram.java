class Solution {
    public boolean checkIfPangram(String s) {
        boolean found = false;
        
        for (char curr = 'a'; curr <= 'z'; curr++) {
            for (char c : s.toCharArray()) 
                if (c == curr) 
                    found = true;
            if (!found) return false;
            found = false;
        } //for
        
        return true;
    } //check
} //Solution