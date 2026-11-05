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
        HashMap<Node, Node> storeMap = new HashMap<>();
        Node curr1 = head;
        Node curr2 = head;

        while(curr1!=null) {
            storeMap.put(curr1, new Node(curr1.val));
            curr1 = curr1.next;
        }

        while(curr2!=null) {
            Node createdNode = storeMap.get(curr2);
            createdNode.next = storeMap.get(curr2.next);
            createdNode.random = storeMap.get(curr2.random);
            curr2 = curr2.next;
        }

        return storeMap.get(head);
    }
}
