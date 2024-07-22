class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length, j = 0;
        String [] heightMap = new String [100001];
        String [] sol = new String [n];

        for (int i = 0; i < n; i++) {
            heightMap[heights[i]] = names[i];
        } //for

        for (int i = 100000; i >= 0; i--) {
            if (heightMap[i] != null) {
                sol[j++] = heightMap[i];
            } //if
        } //for
        
        return sol;
    } //sortPeople
} //Sol

//1. HashMap O(nlog(n))
//2. TreeMap (O(nlog(n)))
//3. Bucket Sort (O(n))
//4. Convert to tuple and sort using lambda