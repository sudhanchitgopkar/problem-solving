class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack <Integer> s = new Stack <Integer> ();
        int [] sol = new int [temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                sol[s.peek()] = i - s.pop();                           
            }
            s.push(i);
        } //for
        
        return sol;
    } //dailyTemo
} //Sol