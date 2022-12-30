class Solution {
    public int[] getOrder(int[][] tasks) {
        int [] sol = new int [tasks.length];
        PriorityQueue <Task> curr = new PriorityQueue <> ();
        int soli = 0, listi = 0, currTime = 0;

        List<Task> taskList = new ArrayList <> ();
        for (int [] task : tasks) taskList.add(new Task(listi++, task[0], task[1]));

        Collections.sort(taskList, new Comparator<Task>(){
            public int compare(Task t1, Task t2) {
                return t1.start != t2.start ? t1.start - t2.start :
                t1.duration != t2.duration ? t1.duration - t2.duration :
                t1.id - t2.id;
            } //compare
        });

        listi = 0;
        curr.offer(taskList.get(listi++));
        currTime = curr.peek().start;

        while (!curr.isEmpty() || listi < taskList.size()) {
            Task t = !curr.isEmpty() ? curr.poll() : taskList.get(listi++);
            currTime = currTime > t.start ? currTime : t.start;
            while (listi < taskList.size() 
            && taskList.get(listi).start <= currTime + t.duration)  
                curr.offer(taskList.get(listi++));
            sol[soli++] = t.id;
            currTime += t.duration;
        } //while
        
        return sol;
    } //getOrder
} //Sol

public class Task implements Comparable<Task> {
    protected int id, start, duration;
    
    public Task (int id, int start, int duration) {
        this.id = id;
        this.start = start;
        this.duration = duration;
    } //constructor

    @Override public int compareTo(Task t) {
        if (this.duration < t.duration) return -1;
        else if (this.duration > t.duration) return 1;
        else if (this.id < t.id) return -1;
        else if (this.id > t.id) return 1;
        else return 0; //unreachable
    } //compareTo
} //Sol