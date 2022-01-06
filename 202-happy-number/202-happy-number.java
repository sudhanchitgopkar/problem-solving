class Solution {
    public boolean isHappy(int n) {
        
        HashSet <Integer> seen = new HashSet <Integer> ();
        int squaredSum = n;
        
        while (!seen.contains(squaredSum)) {
            //3. add to seen
            seen.add(squaredSum);
            
            //1.finding squaredSum
            int temp = 0;
            while(squaredSum > 0) {
                temp += (squaredSum % 10)*(squaredSum % 10);
                squaredSum /= 10;
            } //while
            
            squaredSum = temp;
                
            //2. if == 1, return true
            if (squaredSum == 1) return true;
        } //while
        
        return false;
        
    } //isHappy
} //Solution