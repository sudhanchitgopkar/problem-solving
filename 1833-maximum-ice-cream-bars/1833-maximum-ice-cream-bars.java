class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int sol = 0;
        Arrays.sort(costs);
        
        for (int cost : costs) 
            if ((coins -= cost) >= 0) sol++;
            else break;

       return sol; 
    } //maxIceCream
} //Sol