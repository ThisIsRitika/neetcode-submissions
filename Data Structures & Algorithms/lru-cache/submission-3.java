class LRUCache {   

    //custom doubly Linked list
    public class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(){}
        Node(int key, int val){ 
            this.val=val;
            this.key=key;
        }
        Node(int key, int val, Node next){
            this.key=key;
            this.val=val;
            this.next=next;
        }
        Node(int key, int val, Node next, Node prev){
            this.key=key;
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }

    //helper functions
    private void removeNode(Node n){
        Node prevN=n.prev;
        Node nextN=n.next;
        prevN.next=nextN;
        nextN.prev=prevN;

    }
    private void addToFirst(Node n){
        Node temp=head.next;
        head.next=n;
        n.next=temp;
        temp.prev=n;
        n.prev=head;
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int size;
    int used;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        size=capacity;
        used=0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            removeNode(n);
            addToFirst(n);
            return n.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(used<size){
            if(map.containsKey(key)){
                map.get(key).val=value;
                Node n=map.get(key);
                removeNode(n);
                addToFirst(n);
            }else{
                Node n=new Node(key, value);
                map.put(key, n);
                addToFirst(n);
                used++;
            }
        }else{
            if(map.containsKey(key)){
                map.get(key).val=value;
                Node n=map.get(key);
                removeNode(n);
                addToFirst(n);
            }else{
                Node lru=tail.prev;
                map.remove(lru.key);
                removeNode(lru);
                Node n=new Node(key, value);
                map.put(key, n);
                addToFirst(n);

            }
        }
           
    }
}
