class Solution {
    public List<String> fizzBuzz(int n) {
        List <String> sol = new ArrayList <String> ();
        int i = 1;
        
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0)
                sol.add("FizzBuzz");
            else if (i % 3 == 0)
                sol.add("Fizz");
            else if (i % 5 == 0)
                sol.add("Buzz");
            else
                sol.add(Integer.toString(i));
            i++;
        } //while
        
        return sol;
    } //fizzbuzz
} //solution