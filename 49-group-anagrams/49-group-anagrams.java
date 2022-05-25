class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap <String, List<String>> ana = new HashMap <String, List<String>> ();
        
        for (String s: strs){
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!ana.containsKey(key)) ana.put(key, new ArrayList<String>());
            ana.get(key).add(s);                         
        } //for
        
        return new ArrayList<List<String>>(ana.values());
    } //groupAnagrams
} //Sol

/*
1. str -> sorted char array: use to tell if ana with other str
2. check if ana already exists
    a. if yes, add str to existing ana list
    b. if no, start new ana list with str
3. package up all ana lists into one list
*/
