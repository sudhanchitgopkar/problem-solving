class Solution {
    public int minPartitions(String n) {
        int min = 0;
        for (int i = 0; i < n.length(); i++) {
            if (Integer.parseInt(n.substring(i,i+1)) > min) min = Integer.parseInt(n.substring(i,i+1));
        } 
        
        return min;
    } //minPartitions
} //Sol