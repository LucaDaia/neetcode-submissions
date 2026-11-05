class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node() {
        this.key = 0;
        this.val = 0;
    }

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    Node(int key, int val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {

    private HashMap<Integer, Node> map;
    private int capacity;

    private Node left;   // LRU (dummy)
    private Node right;  // MRU (dummy)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        left = new Node();
        right = new Node();

        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.prev = right.prev;
        node.next = right;
        right.prev.next = node;
        right.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        } else {
            if (map.size() == capacity) {
                Node lru = left.next;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value, null, null);
            insert(newNode);
            map.put(key, newNode);
        }
    }
}
