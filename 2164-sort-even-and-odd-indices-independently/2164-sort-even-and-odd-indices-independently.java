class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        ArrayList <Integer> o = new ArrayList <Integer>();
        ArrayList <Integer> e = new ArrayList <Integer>();
                
        for (int i = 0; i < nums.length; i++)
            if (i % 2 == 0) e.add(nums[i]);
            else o.add(nums[i]);
        
         Collections.sort(o);
         Collections.sort(e);
        
        int oi = o.size()-1, ei = 0;
        for (int i = 0; i < nums.length; i++)
            if (i % 2 == 0) nums[i] = e.get(ei++);
            else nums[i] = o.get(oi--);
        
        return nums;
    } //sortEvenOdd
} //class