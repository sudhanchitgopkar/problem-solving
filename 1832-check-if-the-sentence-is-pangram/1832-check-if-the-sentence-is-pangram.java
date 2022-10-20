
class Solution {
    public boolean checkIfPangram(String s) {
        return new HashSet<Character>(Arrays.asList(s.chars().mapToObj(c -> (char)c).toArray(Character[]::new))).size() == 26;
        
    } //check
} //Solution