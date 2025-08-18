/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //2pass algo - first we will just copy the values into the hashmap because multiple nodes can point to 
        //same node again using random pointers so using hashmap we will have only one copy.

        HashMap<Node,Node> map = new HashMap<>();
        Node crnt = head;
        while(crnt!=null){
            map.put(crnt,new Node(crnt.val));
            crnt = crnt.next;
        }

        crnt = head;
        while(crnt!=null){
            map.get(crnt).next = map.get(crnt.next); //we have to point it to the newly created node 
            map.get(crnt).random = map.get(crnt.random);
            crnt = crnt.next;
        }

        return map.get(head);
    }
}