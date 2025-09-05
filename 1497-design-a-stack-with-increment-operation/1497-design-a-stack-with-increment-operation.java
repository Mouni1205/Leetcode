class CustomStack {
    int arr[];
    int maxSize;
    Stack<Integer> stack;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.size()<maxSize) stack.push(x);
    }
    
    public int pop() {
       if(stack.size()<=0) return -1;
       //we have add the increment value to the top element and also add this to previous element
       int i = stack.size()-1;
       if(i>0)
        arr[i-1]+=arr[i];
        int result = arr[i]+stack.pop();
        arr[i]=0;
       return result;
    }
    
    public void increment(int k, int val) {
        int i = Math.min(k,stack.size())-1;
        //if the index is valid we will keep track of how much we have to increment at that particular index
        if(i>=0)
            arr[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */