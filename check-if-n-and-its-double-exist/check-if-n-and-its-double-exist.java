class Solution {
    public boolean checkIfExist(int[] arr) {
        
        HashSet <Double> vals = new HashSet <Double> ();
        
        for (int val:arr) {
            if (vals.contains(val * 2.0) || vals.contains(val / 2.0))
                return true;
            else 
                vals.add(val * 1.0);
        } //for
        
        return false;
        
    } //checkIfExist
} //Solution