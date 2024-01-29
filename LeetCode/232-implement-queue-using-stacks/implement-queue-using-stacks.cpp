class MyQueue {
public:
    stack <int> a, b;
    MyQueue() {
        // B)
    } //myq
    
    void push(int x) {
        while (!b.empty()) {
            a.push(b.top());
            b.pop();
        } //while

        a.push(x);
    } //push
    
    int pop() {
        while (!a.empty()) {
            b.push(a.top());
            a.pop();
        } //while

        int pop = b.top();
        b.pop();
        return pop;
    } //pop
    
    int peek() {
        while (!a.empty()) {
            b.push(a.top());
            a.pop();
        } //while
        
        return b.top();
    } //peek
    
    bool empty() {
        return a.empty() && b.empty();
    } //empty
};
