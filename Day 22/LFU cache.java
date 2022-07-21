// LFU cache 
// DoublyLinked List and cache Map, frequency Map
// Accordingly we will store the Doubly LinkedList for each frequency 


// Code:

class LFUCache {
    
    class DLLNode{
        int key,value,freq;
        DLLNode next, prev;
        DLLNode(int key, int value){
            this.key = key;
            this.value = value;
            this.freq=1;
        }
    }
    
    class DLList{
        DLLNode head, tail;
        int listsize;
        DLList(){
            head = new DLLNode(0,0);
            tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void addNode(DLLNode currNode){
            currNode.next = head.next;
            currNode.prev = head;
            head.next = currNode;
            currNode.next.prev = currNode;
            listsize++;
        }
        
        public void removeNode(DLLNode currNode){
            currNode.next.prev = currNode.prev;
            currNode.prev.next = currNode.next;
            listsize--;
        }
        
        public DLLNode removeTail(){
            if(listsize>0){
                DLLNode tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }
            return null;
        }
    }
    
    final int capacity;
    int currSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DLList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize=0;
        this.minFrequency=0;
        
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            DLLNode currNode = cache.get(key);
            updateNode(currNode);
            return currNode.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        
        if(cache.containsKey(key)){
            DLLNode currNode = cache.get(key);
            currNode.value = value;
            updateNode(currNode);
        }
        else{
            currSize++;
            if(currSize>capacity){
                DLList minFreqList = freqMap.get(minFrequency);
                DLLNode deleteNode = minFreqList.removeTail();
                cache.remove(deleteNode.key);
                currSize--;
            }
            
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key,value);
            
            DLList currList = freqMap.getOrDefault(1,new DLList());
            currList.addNode(newNode);
            freqMap.put(1,currList);
            cache.put(key, newNode);
        }
    }
    
    public void updateNode(DLLNode currNode){
        int currFreq = currNode.freq;
        DLList currList = freqMap.get(currFreq);
        currList.removeNode(currNode);
        
        if(currFreq == minFrequency && currList.listsize==0){
             minFrequency++;
        }
        
        currNode.freq++;
        
        DLList newList = freqMap.getOrDefault(currNode.freq, new DLList());
        newList.addNode(currNode);
        freqMap.put(currNode.freq , newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */