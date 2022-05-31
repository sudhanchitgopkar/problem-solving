class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String, List<String>> h = new HashMap <String, List<String>> ();
        List<List<String>> sol;
        
        for (String s : strs) {
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            
            if (h.containsKey(key)) {
                h.get(key).add(s);
            } else {
                h.put(key, new ArrayList<String>());
                h.get(key).add(s);
            }
        } //for
       
        sol = new ArrayList<List<String>> (h.values());
        return sol;
    } //groupAnagrams
} //Sol
