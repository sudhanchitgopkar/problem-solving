class BrowserHistory {
    ArrayList <String> history = new ArrayList<> ();
    int curr = 0, size = 0;
    
    public BrowserHistory(String homepage) {
        history.add(homepage);
        size++;
    }
    
    public void visit(String url) {
        history.add(curr + 1, url);
        curr++;
        size = curr + 1;
    }
    
    public String back(int steps) {
        if (curr - steps >= 0) curr -= steps;
        else curr = 0;
        return history.get(curr);
    }
    
    public String forward(int steps) {
        if (size > curr + steps) curr += steps;
        else curr = size - 1;
        return history.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */