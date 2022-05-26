class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> ana = new HashMap<String,ArrayList<String>>();
        
        for (String s : strs) {
            char [] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            
           
            if (!ana.containsKey(key)) 
                ana.put(key,new ArrayList<String>());
            ana.get(key).add(s);
        } //for
        
        return new ArrayList<List<String>> (ana.values());
    } //groupAnagrams
} //Sol

/*
1. convert each str -> its sorted char string representation X
2. pair anagrams together X
3. return paired anagrams


eat -> aet
tea -> aet

cat -> act
*/