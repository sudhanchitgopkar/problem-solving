class Solution {
    public int[][] kClosest(int[][] points, int k) {        
        int [][] sol = new int [k][2];
        PriorityQueue <int []> pointQueue = new PriorityQueue <int []> (new Comparator <int []> () {
            
            @Override
            public int compare (int [] b, int [] a) {
                return ((a[0]*a[0]) + (a[1]*a[1])) - ((b[0]*b[0]) + (b[1]*b[1]));
            } //compareTo
        }); //PriorityQueue
                                                                             
        for (int [] point : points) {
            pointQueue.offer(point);
            
            if (pointQueue.size() > k) {
                pointQueue.poll();
            } //if
        } //for
        
        for (int i = 0; i < k; i++) {
            sol[i] = pointQueue.poll();
        } //for
        
        return sol;
    } //kClosest
} //Sol