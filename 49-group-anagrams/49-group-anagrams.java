class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> sol = new ArrayList<List<String>> ();
        HashMap <String, List<String>> anagrams = new HashMap <String, List<String>> ();
        
        for (String s : strs) {
            char [] sortedChars = s.toCharArray();
            Arrays.sort(sortedChars);
            String sorted = String.valueOf(sortedChars);
            if (!anagrams.containsKey(sorted)) anagrams.put(sorted, new ArrayList<String>());
            anagrams.get(sorted).add(s);
        } //for
        
        for (String key : anagrams.keySet()) {
            sol.add(anagrams.get(key));
        } //for
        
        return sol;
    } //groupAnagrams
} //Sol
