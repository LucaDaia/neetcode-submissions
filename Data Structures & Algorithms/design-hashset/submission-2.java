class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        this.val = -1;
        this.next = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyHashSet {

    public ListNode[] buckets;

    public MyHashSet() {
        buckets = new ListNode[100];

        for(int i = 0; i < 100; i++) {
            buckets[i] = new ListNode();
        }
    }

    public void add(int key) {

        int index = key % 100;
        ListNode curr = buckets[index];

        // Check if the key already exists
        while(curr != null) {
            if(curr.val == key) {
                return;
            }
            curr = curr.next;
        }

        // Insert the new key
        ListNode temp = new ListNode(key);
        curr = buckets[index];

        if(curr.val == -1) {
            buckets[index] = temp;
        } else {
            while(curr.next != null) {
                curr = curr.next;
            }

            curr.next = temp;
        }
    }

    public void remove(int key) {

        int index = key % 100;
        ListNode curr = buckets[index];

        // Check if the head contains the key
        if(curr.val == key) {

            if(curr.next == null) {
                buckets[index] = new ListNode();
            } else {
                buckets[index] = curr.next;
            }

            return;
        }

        // Search the remaining linked list
        while(curr.next != null) {

            if(curr.next.val == key) {
                curr.next = curr.next.next;
                return;
            }

            curr = curr.next;
        }
    }

    public boolean contains(int key) {

        int index = key % 100;
        ListNode curr = buckets[index];

        while(curr != null) {

            if(curr.val == key) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }
}