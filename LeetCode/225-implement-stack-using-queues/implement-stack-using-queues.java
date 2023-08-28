class MyStack {
    Queue <Integer> a, b;

    public MyStack() {
        a = new LinkedList <> ();
        b = new LinkedList <> ();
    } //myStack
    
    public void push(int x) {
        a.offer(x);
    } //push
    
    public int pop() {
        while (a.size() > 1) {
            b.offer(a.poll());
        } //while
        int res = a.poll();
        while (!b.isEmpty()) {
            a.offer(b.poll());
        } //while
        return res;
    } //pop
    
    public int top() {
        while (a.size() > 1) {
            b.offer(a.poll());
        } //while
        int res =  a.peek();
        b.offer(a.poll());
        while (!b.isEmpty()) {
            a.offer(b.poll());
        } //while
        return res;
    } //top
    
    public boolean empty() {
        return a.size() == 0;
    } //empty
} //MyStack


//1,1,2
//2,1,1
//1,1
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */