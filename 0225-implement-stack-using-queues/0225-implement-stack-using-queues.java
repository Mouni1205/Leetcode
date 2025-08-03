class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    public void push(int x) {
        first.offer(x);
    }
    
    public int pop() {
        while(first.size()!=1){
            second.offer(first.poll());
        }
        while(second.size()>0){
            first.offer(second.poll());
        }
        return first.poll();
    }
    
    public int top() {
         while(first.size()>1){
            second.offer(first.poll());
        }
        int top = first.poll();
        while(second.size()>0){
            first.offer(second.poll());
        }
        first.offer(top);
        return top;  
    }
    
    public boolean empty() {
        return first.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */