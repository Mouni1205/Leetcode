class MyCircularQueue {
    int queue[];
    int front = 0;
    int rear = -1;
    int len = 0;
    int k = 0;
    public MyCircularQueue(int k) {
        queue = new int[k];
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            rear = (rear+1)%k;
            queue[rear]=value;
            len++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
       if(!isEmpty()){
            front =(front+1)%k;
            len--;
            return true;
       }
       return false;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return len == 0;
    }
    
    public boolean isFull() {
        return len == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */