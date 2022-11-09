class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
		    int mv = a & b;
		    a ^= b;
		    b = mv << 1;
	    } //while
	
	    return a;     
    }
}