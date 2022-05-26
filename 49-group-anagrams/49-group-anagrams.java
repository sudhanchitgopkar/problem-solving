class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String, ArrayList<String>> ana = new HashMap <String, ArrayList<String>> ();
        
        for (String s : strs) {
            char [] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            
            if (ana.containsKey(key)) {
                ana.get(key).add(s);
            } else {
                ana.put(key, new ArrayList<String>());
                ana.get(key).add(s);
            } //if
        } //for
        
        return new ArrayList<List<String>> (ana.values());
    } //groupAnagrams
} //Sol

/*
1. convert each str -> sorted char representation X
2. group all sets of anagrams X
3. return our set of sets
*/

/*
eat -> a,e,t -> aet
tea -> a,e,t -> aet

bat -> a,b,t -> abt
*/