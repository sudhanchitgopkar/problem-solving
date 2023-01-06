class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sol = 0;
        
        for (int cost : costs) 
            if ((coins -= cost) >= 0) sol++;
            else break;

       return sol; 
    } //maxIceCream
} //Sol