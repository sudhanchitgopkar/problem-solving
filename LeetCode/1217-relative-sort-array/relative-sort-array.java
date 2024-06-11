class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length, soli = 0;
        
        HashMap <Integer, Integer> freq = new HashMap <> ();
        HashSet <Integer> a2set = new HashSet <> ();
        int [] sol = new int [m];

        Arrays.sort(arr1);
        for (int val : arr2) a2set.add(val);

        //Populate frequency map of arr1
        for (int val : arr1) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        } //for

        //Populate relative sorted portion
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < freq.get(arr2[i]); j++) {
                sol[soli++] = arr2[i];
            } //for
        } //for

        for (int i = 0; i < m; i++) {
            if (!a2set.contains(arr1[i])) {
                sol[soli++] = arr1[i];
            } //if
        } //for

        return sol;
    } //relativeSortArray
} //Sol