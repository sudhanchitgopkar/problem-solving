class Solution {
    public int carFleet(int target, int[] position, int[] speed) {        
        TreeMap <Integer, Double> tm = new TreeMap <Integer, Double> (Collections.reverseOrder());
        int numFleets = 0;
        double prev = -1;
        
        for (int i = 0; i < position.length; i++) {
            tm.put(position[i], ((target - position[i]) * 1.0)/speed[i]);
        } //for
        
        for (double d : tm.values()) {
            if (d > prev) { 
                numFleets++; 
                prev = d;
            } //if
        } //for
   
        return numFleets;
    } //carFleet
} //Sol