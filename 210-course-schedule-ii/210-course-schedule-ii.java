class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] prereqs = new int [numCourses];
        HashMap <Integer, List<Integer>> nextCourses = new HashMap <Integer, List<Integer>> ();
        
        for (int [] coursePair : prerequisites) {
            prereqs[coursePair[0]]++;
            if (!nextCourses.containsKey(coursePair[1])) {
                nextCourses.put(coursePair[1],new ArrayList <Integer> ());
            } //if  
            nextCourses.get(coursePair[1]).add(coursePair[0]);
        } //for
        
        Queue <Integer> noPrereqs = new LinkedList <Integer> ();
        
        for (int course = 0; course < prereqs.length; course++) {
            if (prereqs[course] == 0) {
                noPrereqs.add(course);
            } //if
        } //for
        
        int [] sorted = new int [numCourses];
        int sortIndex = 0;
        
        while (!noPrereqs.isEmpty()) {
            int currCourse = noPrereqs.poll();
            sorted[sortIndex++] = currCourse;
            if (!nextCourses.containsKey(currCourse)) continue;
            for (int nextCourse : nextCourses.get(currCourse)) {
                prereqs[nextCourse]--;
                if (prereqs[nextCourse] == 0) {
                    noPrereqs.add(nextCourse);
                } //if
            } //for
        } //while
        
        if (sortIndex != numCourses) {
            return new int [] {};
        } else { 
            return sorted;
        } //if
    } //findOrder
} //Solution