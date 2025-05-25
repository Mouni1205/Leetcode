class Node{
    int key,value;
    Node prev,next;
    Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    HashMap<Integer,Node> map;
    int capacity = 0;
    Node dummyHead,dummyTail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new Node(-1,-1);
        dummyTail = new Node(-1,-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        //we have to do two things return value from map and then if the key exists we want to remove the node and then add it to the front
        if(map.containsKey(key)){
            Node crnt = map.get(key);
            remove(crnt);
            addFirst(crnt);
            return crnt.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node crnt = map.get(key);
            crnt.value = value;
            map.put(key,crnt);
            remove(crnt);
            addFirst(crnt);
        }else{
            Node crnt = new Node(key,value);
            map.put(key,crnt);
            if(map.size()>capacity){
                map.remove(dummyTail.prev.key);
                remove(dummyTail.prev);
            }
            addFirst(crnt);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public void addFirst(Node node){
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next = node;
        node.next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */