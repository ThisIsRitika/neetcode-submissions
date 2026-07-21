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
        // Case 1: Key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToFirst(node);
            return;
        }

        // Case 2: Cache is full
        if (used == size) {
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        } else {
            used++;
        }

        // Case 3: Insert new node
        Node node = new Node(key, value);
        addToFirst(node);
        map.put(key, node);
       
    }
}
