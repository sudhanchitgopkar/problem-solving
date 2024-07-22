class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length, j = n - 1;
        TreeMap <Integer, String> tm = new TreeMap <> ();
        String [] sol = new String [n];

        for (int i = 0; i < n; i++) {
            tm.put(heights[i], names[i]);
        } //for

        for (int key : tm.keySet()) {
            sol[j--] = tm.get(key); 
        } //for


        return sol;
    } //sortPeople
} //Sol

//1. HashMap O(nlog(n))
//2. TreeMap (O(nlog(n)))
//3. Bucket Sort (O(n))
//4. Convert to tuple and sort using lambda