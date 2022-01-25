class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap <Character, Integer> freq = new HashMap <Character, Integer> ();
        
        for (int i = 0; i < s.length(); i++) {
            if (freq.containsKey(s.charAt(i)))
                freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
            else freq.put(s.charAt(i), 1);
        } //for
                  
        for (int i = 0; i < t.length(); i++) {
            if (freq.containsKey(t.charAt(i)))
                freq.put(t.charAt(i), freq.get(t.charAt(i)) - 1);
            else return false;
        } //for
                  
        for (Integer i : freq.values())
            if (i != 0) return false;
                  
        return true;
    } //isAnagram
} //Solution