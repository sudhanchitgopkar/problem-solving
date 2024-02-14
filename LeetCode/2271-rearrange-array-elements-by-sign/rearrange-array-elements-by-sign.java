class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] sol = new int [nums.length];
        Queue <Integer> pos = new LinkedList <> (), neg = new LinkedList <> ();

        for (int num : nums) {
            if (num > 0) pos.offer(num);
            else neg.offer(num);
        } //for

        int i = 0;
        while (!pos.isEmpty() && !neg.isEmpty()) {
            sol[i++] = pos.poll();
            sol[i++] = neg.poll();
        } //while
        
        return sol;
    } //rearrange
} //Sol