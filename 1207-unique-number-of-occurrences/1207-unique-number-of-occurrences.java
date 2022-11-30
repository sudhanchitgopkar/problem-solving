class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap <Integer, Integer> freq = new HashMap<> ();
        for (int num : arr) freq.put(num,freq.getOrDefault(num,0) + 1);
        HashSet <Integer> seen = new HashSet<> ();
        for (int key : freq.keySet()) 
            if (seen.contains(freq.get(key))) return false;
            else seen.add(freq.get(key));
        return true;
    } //uniqueOccurrences
} //Sol