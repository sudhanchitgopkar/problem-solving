class Solution {
    public int[] sortEvenOdd(int[] nums) {        
        //ArrayList <Integer> o = new ArrayList <Integer>();
        //ArrayList <Integer> e = new ArrayList <Integer>();
        int of = 0;
        if (nums.length % 2 != 0) of = 1;
        
        int [] o = new int [nums.length/2];
        int [] e = new int [nums.length/2 + of];
        
        int oi = 0, ei = 0;
        
        for (int i = 0; i < nums.length; i++)
            if (i % 2 == 0) e[ei++] = nums[i];
            else o[oi++] = nums[i];
        
        Arrays.sort(e);
        Arrays.sort(o);
        
        oi = o.length-1;
        ei = 0;
        
        for (int i = 0; i < nums.length; i++)
            if (i % 2 == 0) nums[i] = e[ei++];
            else nums[i] = o[oi--];
        
        /*
        for (int i = 0; i < nums.length; i++)
            if (i % 2 == 0) e.add(nums[i]);
            else o.add(nums[i]);
        */
         //Collections.sort(o);
         //Collections.sort(e);
        
        //int oi = o.size()-1, ei = 0;
        /*
        for (int i = 0; i < nums.length; i++)
            if (i % 2 == 0) nums[i] = e.get(ei++);
            else nums[i] = o.get(oi--);
        */
        
        return nums;
    } //sortEvenOdd
} //class