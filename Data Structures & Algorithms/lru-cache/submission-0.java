class LRUCache {
    // will need to create a ListNode
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        // do i put size here??
        public ListNode(){}

        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    ListNode head = new ListNode();
    ListNode tail = new ListNode();

    int cap;
    Map<Integer,ListNode> hm = new HashMap<>();
    public void deleteNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToFront(ListNode node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
        head.next.next.prev = node;
    }

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        else {
            ListNode node = hm.get(key);
            deleteNode(node);
            addToFront(node);
            // return after move ment of node to front .
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            ListNode node = hm.get(key);
            node.val = value;
            node.key = key;
            deleteNode(node);
            addToFront(node);
        }else{ // we need to create a Linked List and have a value size in it and compare it
            ListNode node = new ListNode(key, value);
            
            if(cap <= hm.size()){
                ListNode lru = tail.prev;   // save the node first
                deleteNode(lru);
                hm.remove(lru.key);
            }
            // add it
            hm.put(key, node);
            addToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */