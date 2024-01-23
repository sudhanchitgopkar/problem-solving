class Solution {
    public int maxLength(List<String> arr) {
        return backtrack("", 0, arr);
    } //maxLen

    int backtrack(String curr, int i, List<String> arr) {
        if (i == arr.size()) return curr.length();
        
        boolean valid = true;
        HashSet<Character> seen = new HashSet <> ();
        for (int j = 0; j < arr.get(i).length(); j++) {
            if (curr.contains(arr.get(i).charAt(j)+"") || 
                seen.contains(arr.get(i).charAt(j))) {
                valid = false;
                break;
            } else {
                seen.add(arr.get(i).charAt(j));
            } //if
        } //for 

        if (valid) {
            curr += arr.get(i);
            int with = backtrack(curr, i + 1, arr);
            curr = curr.substring(0, curr.length() - arr.get(i).length());
            int without = backtrack(curr, i + 1, arr);
            return Math.max(with, without);
        } else {
            return backtrack(curr, i + 1, arr);
        } //if
    } //backtrack
} //Sol