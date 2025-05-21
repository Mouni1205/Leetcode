class Node {
    int key,value;
    Node prev;
    Node next;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    HashMap<Integer , Node> map;
    Node head,tail;
    int capacity;
    public LRUCache(int capacity) {
        //initialize capacity,map and create dummy head and tail 
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    //we have to update both prev and next nodes of crnt
    public  void remove(Node crnt){
        crnt.prev.next = crnt.next;
        crnt.next.prev = crnt.prev;
    }
    public  void insert(Node crnt){
        crnt.next = head.next;
        crnt.next.prev = crnt;
        head.next = crnt;
        crnt.prev = head;
    }
    public int get(int key) {
        //if the map contains key we have to first remove and then insert since we accessed it recently it goes to the front of the linkedlist
        //since the order of the linked list goes from recently accessed keys to the least accessed keys.
        if(map.containsKey(key)){
            Node crnt = map.get(key);
            remove(crnt);
            insert(crnt);
            return crnt.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //if the map contains key then remove and then insert at the beginning
        if(map.containsKey(key)){
            remove(map.get(key));
            map.remove(key);
        }  
        //if the capacity is full then remove the least accessed which is the tail.prev of the DLL; tail is a dummy node and also from map
        if(map.size()==capacity){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        //insert into DLL and also into the map
        Node crnt = new Node(key,value);
        insert(crnt);
        map.put(key,crnt);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */