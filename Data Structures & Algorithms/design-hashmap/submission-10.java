public class ListNode {
    public int key;
    public int val;
    public ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }

    public ListNode() {
        this.key = -1;
        this.val = -1;
        this.next = null;
    }
}

class MyHashMap {
    public ListNode[] buckets;

    public MyHashMap() {
        buckets = new ListNode[100];
        for (int i = 0; i < 100; i++) {
            buckets[i] = new ListNode();
        }
    }

    public void put(int key, int value) {
        ListNode curr = buckets[key % 100];

        if (curr.key == -1) {
            buckets[key % 100] = new ListNode(key, value);
            return;
        }

        while (curr.next != null) {
            if (curr.key == key) {
                curr.val = value;
                return;
            }
            curr = curr.next;
        }

        if (curr.key == key) {
            curr.val = value;
            return;
        } else {
            ListNode temp = new ListNode(key, value);
            curr.next = temp;
        }
    }

    public int get(int key) {
        ListNode curr = buckets[key % 100];

        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        ListNode prev = buckets[key % 100];
        ListNode curr = prev;

        if (curr.key == key) {
            buckets[key % 100] = curr.next != null ? curr.next : new ListNode();
            return;
        }

        curr = curr.next;

        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}
