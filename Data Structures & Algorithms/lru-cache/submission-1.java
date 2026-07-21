class LRUCache {

    HashMap<Integer, Integer> map;
    LinkedList<Integer> list;
    int size;
    int used;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        list=new LinkedList<>();
        size=capacity;
        used=0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            list.remove((Integer) key);
            list.addFirst(key);
            return map.get(key);
        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        if(used<size){
            if(map.containsKey(key)){
                list.remove((Integer) key);
                list.addFirst(key);
                map.put(key,value);
            }else{
                map.put(key,value);
                list.addFirst(key);
                used++;
            }
            
        }else{
            if(map.containsKey(key)){
                list.remove((Integer) key);
                list.addFirst(key);
                map.put(key,value);
            }else{
                map.remove(list.getLast());
                list.removeLast();
                list.addFirst(key);
                map.put(key,value);
            }
           
        }
        
    }
}
