/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToNew = new HashMap<>();

        Node curr1 = head;
        Node curr2 = head;

        while(curr1 != null) {
            Node copy = new Node(curr1.val);
            oldToNew.put(curr1, copy);
            curr1 = curr1.next;
        }

        while(curr2 != null) {
            Node temp = oldToNew.get(curr2);
            temp.next = oldToNew.get(curr2.next);
            temp.random = oldToNew.get(curr2.random);
            curr2 = curr2.next;
        }

        return oldToNew.get(head);
    }
}
