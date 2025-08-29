class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int k,int v) { key = k;value=v;};
    }
    private int capacity;
    private HashMap<Integer,Node> map;
    private Node head,tail; // dummy node 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next= tail;
        tail.prev= head;
        
    }
    // Remove nodee from linkedlist 
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // Isertion in the linked list 
    private void insert(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node); // move to most recent
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing
            Node node = map.get(key);
            remove(node);
        } else if (map.size() == capacity) {
            // Evict least recently used (head.next)
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */