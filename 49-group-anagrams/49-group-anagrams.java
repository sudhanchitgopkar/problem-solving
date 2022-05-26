class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String, List<String>> ana = new HashMap <String, List<String>> ();
        
        for (String s : strs) {
            char [] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            
            if (!ana.containsKey(key))
                ana.put(key, new ArrayList<String>());
            
            ana.get(key).add(s);
        } //for
       
        return new ArrayList<List<String>> (ana.values());
    } //groupAnagrams
} //Sol

