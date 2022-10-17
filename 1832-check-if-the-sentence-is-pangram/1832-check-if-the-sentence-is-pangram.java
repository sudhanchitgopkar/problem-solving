class Solution {
    public boolean checkIfPangram(String s) {
        int [] f = new int [26];
        
        for (char c : s.toCharArray()) f[c-'a']++;
        for (int n : f) if (n == 0) return false;
        return true;
        
    }
}