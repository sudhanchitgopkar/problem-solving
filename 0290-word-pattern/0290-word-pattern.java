class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap <Character, String> lookup = new HashMap <> ();
        HashSet <String> seen = new HashSet <> ();
        String [] words = s.split(" ");
        char [] keys = pattern.toCharArray();

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < keys.length; i++) {
            if (!lookup.containsKey(keys[i])) 
                if (seen.contains(words[i])) return false;
                else lookup.put(keys[i], words[i]);
            else if (!lookup.get(keys[i]).equals(words[i])) return false;
            seen.add(words[i]);
        } //for

        return true;
    } //wordPattern
} //Sol