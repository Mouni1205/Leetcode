class CustomStack {
    int arr[];
    int crnt=0;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(crnt==arr.length) return;
        arr[crnt]=x;
        crnt++;
    }
    
    public int pop() {
        if(crnt==0) return -1;
        return arr[--crnt];
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k&&i<crnt;i++){
            arr[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */