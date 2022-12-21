class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean [rooms.size()];
        visited[0] = true;
        Queue <Integer> q = new LinkedList <> (rooms.get(0));

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (visited[curr]) continue;

            for (int key : rooms.get(curr)) if (!visited[key]) q.offer(key);
            visited[curr] = true;
        } //while
        
        for (boolean b : visited) if (!b) return false;
        return true;
    } //canVisitAll
} //Sol