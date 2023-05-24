class Solution {
    public long maxScore(int[] n1, int[] n2, int k) {
        long n = n1.length, currSum = 0, maxScore = 0;
        List <Pair> pairs = new ArrayList <> ();

        //turn corresponding n1, n2 vals into pairs
        for (int i = 0; i < n; i++) pairs.add(new Pair(n1[i], n2[i]));

        //sort pairs by n2 (highest to lowest)
        Collections.sort(pairs);

        //define pq as min heap based on n1 vals
        PriorityQueue <Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.n1 - p2.n1;
            } //compare
        });

        for (Pair pair : pairs) {
            //add pair to pq and update the sum
            pq.offer(pair); 
            currSum += pair.n1;

            //if we've gone over our max num elements
            if (pq.size() > k) {
                //remove the smallest n1 and update sum
                currSum -= pq.poll().n1; 
            }  //if 

            //if we're at our max elements
            if (pq.size() == k) {
                //calculate current score and update max as needed
                maxScore = Math.max((long)currSum * pair.n2, maxScore);
            } //if
        } //for

        return maxScore;
    } //maxScore
} //Sol

class Pair implements Comparable<Pair> {
    protected int n1, n2;

    public Pair (int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    } //constructor

    @Override
    public int compareTo(Pair p) {
        //bigger n2 = greater
        return p.n2 - n2;
    } //compare
} //Pair