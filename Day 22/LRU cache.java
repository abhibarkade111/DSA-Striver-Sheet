// LRU cache
// Important

// Approach: Map and Doubly Linked List
// Craete a head and tail dummy node
// use map store the key and the address of the node 
// Lru node is present at the right after the tail 
// Most recentaly used node is present right after head node

// Code :

class LRUCache {
    Node head = new Node(0,0), tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap<>();
    int capacity;
    
    class Node{
        int key,value;
        Node next,prev;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity= capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node= map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
            insert(node);
        }
        else{
            insert(node);
        }
    }
    
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insert(Node node){
        map.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */