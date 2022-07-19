class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> dependencyMap = new HashMap<Integer,List<Integer>> ();
        int [] dependencies = new int [numCourses];
        int [] topsort = new int [numCourses];
        int topsortindex = 0;
        
        for (int [] pair : prerequisites) {
            dependencies[pair[0]]++; //initialize dependency frequencies
            if (dependencyMap.containsKey(pair[1])) {
                dependencyMap.get(pair[1]).add(pair[0]);
            } else {
                dependencyMap.put(pair[1], new ArrayList<> ());
                dependencyMap.get(pair[1]).add(pair[0]);
            } //if
        } //for
        
        Queue <Integer> noDependencies = new LinkedList<Integer> ();
        
        for (int course = 0; course < dependencies.length; course++) {
            if (dependencies[course] == 0) noDependencies.add(course);
        } //for
        
        while (!noDependencies.isEmpty()) {
            int course = noDependencies.poll();
            System.out.println(course);
            topsort[topsortindex++] = course;
            
            if (dependencyMap.containsKey(course))  {
                for (int nextCourse : dependencyMap.get(course)) {
                    dependencies[nextCourse]--;
                    if (dependencies[nextCourse] == 0) noDependencies.add(nextCourse);
                } //for    
            } //if
        }  //while
        
        return topsortindex == numCourses;
    } //canFinish
} //sol