class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap <Character, Integer> freq = new LinkedHashMap <Character, Integer> ();
        
        for (int i = 0; i < s.length(); i++) {
            if(freq.containsKey(s.charAt(i)))
                freq.put(s.charAt(i), -1);
            else
                freq.put(s.charAt(i), i);
        } //for
        
        Set <Character> k = freq.keySet();
        
        for (Character c:k)
            if(freq.get(c) != -1)
                return freq.get(c);
        
        return -1;
    } //firstUniqChar
} //Solution