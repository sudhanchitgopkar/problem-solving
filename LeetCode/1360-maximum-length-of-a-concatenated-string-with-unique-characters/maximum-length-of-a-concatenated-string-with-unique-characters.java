class Solution {
    public int maxLength(List<String> arr) {
        return backtrack("", 0, arr);
    } //maxLen

    int backtrack(String curr, int i, List<String> arr) {
        //if we've tried every string
        if (i == arr.size()) return curr.length();
        
        boolean valid = true;
        HashSet<Character> seen = new HashSet <> ();

        for (int j = 0; j < arr.get(i).length() && valid; j++) {
            //if this is in curr or a duplicate char within i
            if (curr.contains(arr.get(i).substring(j, j + 1)) || 
                seen.contains(arr.get(i).charAt(j))) {
                valid = false;
            } else {
                seen.add(arr.get(i).charAt(j));
            } //if
        } //for 

        if (valid) {
            //what's better? using this string or not?
            int without = backtrack(curr, i + 1, arr);
            curr += arr.get(i);
            int with = backtrack(curr, i + 1, arr);            
            return Math.max(with, without);
        } else {
            //we don't have a choice, can't use this string
            return backtrack(curr, i + 1, arr);
        } //if
    } //backtrack
} //Sol