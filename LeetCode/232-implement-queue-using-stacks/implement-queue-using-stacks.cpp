class MyQueue {
public:
    stack <int> a, b;

    MyQueue() {
        // B)
    } //myq
    
    void push(int x) {
        a.push(x);
    } //push
    
    int pop() {
        int pop = -1;
        while (!a.empty()) {
            b.push(a.top());
            a.pop();
        } //while

        pop = b.top();
        b.pop();

        while (!b.empty()) {
            a.push(b.top());
            b.pop();
        } //while

        return pop;
    } //pop
    
    int peek() {
        int peek = -1;
        while (!a.empty()) {
            b.push(a.top());
            a.pop();
        } //while

        peek = b.top();

        while (!b.empty()) {
            a.push(b.top());
            b.pop();
        } //while

        return peek;
    } //peek
    
    bool empty() {
        return a.empty();
    } //empty
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */