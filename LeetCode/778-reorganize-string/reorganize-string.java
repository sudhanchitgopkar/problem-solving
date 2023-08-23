class Solution {
    public String reorganizeString(String s) {
       int [] freq = new int [26];
       PriorityQueue <Pair> maxHeap = new PriorityQueue <> ();
       StringBuilder sol = new StringBuilder();
       Pair withheld = null;

       for (int i = 0; i < s.length(); i++) {
           freq[s.charAt(i) - 'a']++;
       } //for

       for (int i = 0; i < 26; i++) {
           if (freq[i] != 0) {
               Pair curr = new Pair((char)('a' + i), freq[i]);
               maxHeap.offer(curr);
           } //if
       } //for
        
       while (!maxHeap.isEmpty()) {
           Pair curr = maxHeap.poll();
           sol.append(curr.val);
           if (withheld != null) {
                maxHeap.offer(withheld);
           } //if
           withheld = --curr.freq == 0 ? null : curr;
       } //while

       if (withheld != null) {
           //System.out.println(sol.toString());
           return "";
       }
       return sol.toString(); 
    } //reorgString
} //Sol

class Pair implements Comparable <Pair> {
    protected char val;
    protected int freq;

    public Pair (char val, int freq) {
        this.val = val;
        this.freq = freq;
    } //Pair

    @Override
    public int compareTo (Pair p) {
        return Integer.compare(p.freq, freq);
    } //compareTo
} //Pair

