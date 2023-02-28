class Solution {
    public int findMaximizedCapital(int k, int w, 
                                    int[] profits, int[] capital) {
        PriorityQueue <Project> pq = new PriorityQueue<> ();
        LinkedList <Project> projects = new LinkedList <> ();

        for (int i = 0; i < profits.length; i++) {
            projects.add(new Project(capital[i],profits[i]));
        } //for

        Collections.sort(
            projects, 
            new Comparator <Project> () {
                @Override
                public int compare (Project p1, Project p2) {
                    return Integer.compare(p1.cap, p2.cap);
                } //compare
            } //comparator
        ); //Collection

        //System.out.println(projects);
        
        while (k > 0 ) {
            while (projects.size() > 0 && projects.get(0).cap <= w) {
                pq.add(projects.get(0));
                projects.remove(0);
            }

            if (pq.isEmpty()) return w;

            w += pq.poll().profit;
            k--;
        } //while

        return w;
    } //findMaxCap
} //Sol

class Project implements Comparable <Project> {
    protected int cap, profit;

    public Project (int cap, int profit) {
        this.cap = cap;
        this.profit = profit;
    } //Project

    @Override
    public int compareTo (Project p) {
        return Integer.compare(p.profit, profit);
    } //compareTo

    public String toString() {
        return "CAP: " + cap + ", PROF: " + profit;
    }

} //Project