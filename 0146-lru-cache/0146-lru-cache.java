class ListNode{
    int key;
    int value;
    ListNode prev=null;
    ListNode next=null;
    ListNode(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    HashMap<Integer,ListNode> map;
    int capacity;
    ListNode dummyHead;
    ListNode dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map=new HashMap<>();
        dummyHead = new ListNode(-1,-1);
        dummyTail = new ListNode(-1,-1);
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode crnt = map.get(key);
        remove(crnt);
        add(crnt);
        return crnt.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode crnt = map.get(key);
            crnt.value = value;
            remove(crnt);
            add(crnt);
        }else{
        if(map.size()==capacity){
            ListNode lru = dummyTail.prev;
            map.remove(lru.key);
            lru.prev.next=dummyTail;
            dummyTail.prev = lru.prev;
            lru.next = null;
            lru.prev = null;
        }
            ListNode crnt = new ListNode(key,value);
            map.put(key,crnt);
            add(crnt);
        }
    }
    public void add(ListNode node){
        dummyHead.next.prev = node;
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
    }
    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev=node.prev;
        node.prev = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */