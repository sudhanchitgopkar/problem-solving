class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length-1, sol = 0;
        
        while (l <= r) {
            l = people[l] + people[r] <= limit ? l + 1 : l;
            r--;
            sol++;
        } //while
        
        return sol;
    } //numRescueBoats
} //Sol