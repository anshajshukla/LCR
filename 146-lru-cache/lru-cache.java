class LRUCache {
    private int capacity;
    private ArrayList<Integer> cache; // store keys 
    private HashMap<Integer,Integer> map ; // for key value 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        cache.remove((Integer) key);
        cache.add(key);

        return map.get(key);
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key,value);
            cache.remove((Integer) key);
            cache.add(key);
        } else {
            if(cache.size() == capacity){
                int lru = cache.remove(0);
                map.remove(lru);
            }
            cache.add(key);
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */