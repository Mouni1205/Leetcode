class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(x-min);
           
        } else {
            stack.push(x - min);
            if (x < min) min = x;
        }
    }

    public void pop() {
        long top = stack.pop();
        if(top<0) min = min - top;
    }
    
    public int top() {
        if(stack.peek()>=0) return (int)(stack.peek()+min);
        else return (int) min;
    }
    
    public int getMin() {
        return(int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */