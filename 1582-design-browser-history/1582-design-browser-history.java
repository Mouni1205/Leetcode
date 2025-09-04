class Node{
    String val;
    Node prev;
    Node next;
    Node(String val){
        this.val = val;
    }
}
class BrowserHistory {
    Node crnt;
    public BrowserHistory(String homepage) {
        crnt = new Node(homepage); 
    }
    
    public void visit(String url) {
        //this also removes the history 
         Node node = new Node(url);
        node.prev = crnt;
        crnt.next = node;
        crnt = node;
    }
    
    public String back(int steps) {
        while(steps-->0 && crnt.prev!=null){
            crnt = crnt.prev;
        }
        return crnt.val;
    }
    
    public String forward(int steps) {
        while(steps-->0 && crnt.next!=null){
            crnt = crnt.next;
        }
        return crnt.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */