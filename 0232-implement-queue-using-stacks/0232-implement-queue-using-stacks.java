class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while(first.size()>0){
            second.push(first.pop());
        }
        int top = second.pop();
        while(second.size()>0){
            first.push(second.pop());
        }
        return top;
    }
    
    public int peek() {
        while(first.size()>0){
            second.push(first.pop());
        }
        int top = second.peek();
        while(second.size()>0){
            first.push(second.pop());
        }
        return top;
    }
    
    public boolean empty() {
        return first.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */