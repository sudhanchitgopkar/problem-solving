class Solution {
    public int[] plusOne(int[] digits) {
    
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += 1;
            
            if (digits[i] <= 9) 
                return digits;
            else 
                digits[i] = digits[i] % 10;
        } //for
        
        int [] sol = new int [digits.length + 1];
        sol[0] = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            sol[i+1] = digits[i];
        } //for
        
        return sol;
    } //plusOne
} //solution