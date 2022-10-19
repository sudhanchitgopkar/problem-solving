class Solution {
    public boolean checkIfPangram(String s) {
        Set <Character> chars = new HashSet<Character> ();
        
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        } //for
        
        if (chars.size() == 26) return true;
        else return false;
    } //check
} //Solution