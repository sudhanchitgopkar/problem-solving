class Solution {
    public int furthestBuilding(int[] h, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        
        for (int i = 0; i < h.length-1; i++) {
            int d = h[i+1] - h[i];
            if (d > 0) 
            minHeap.add(d);
            if (minHeap.size() > ladders)
                bricks -= minHeap.poll();
            if (bricks < 0) 
                return i;
        } //for
        
        return h.length-1;
    } //furthestBuilding
} //Sol