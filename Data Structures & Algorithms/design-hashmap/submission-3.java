
public class ListNode {
    int key;
    int value;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    public ListNode[] hashContainers;

    public MyHashMap() {
        hashContainers = new ListNode[1001];
    }

    public void put(int key, int value) {
        int idx = myHash(key);
        ListNode head = hashContainers[idx];

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // update existing key
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        // key not found → insert new node
        ListNode newNode = new ListNode(key, value);

        if (prev == null) {
            // empty bucket
            hashContainers[idx] = newNode;
        } else {
            prev.next = newNode;
        }
    }

    public int get(int key) {
        int idx = myHash(key);
        ListNode head = hashContainers[idx];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }

            head = head.next;
        }

        return -1;
    }

    public void remove(int key) {
        int idx = myHash(key);
        ListNode curr = hashContainers[idx];
        ListNode prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    // removing head
                    hashContainers[idx] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return; // IMPORTANT: stop after deletion
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public int myHash(int key) {
        return key % 1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */