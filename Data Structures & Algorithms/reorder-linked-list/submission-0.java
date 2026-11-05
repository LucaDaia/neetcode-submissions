/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
     public void reorderList(ListNode head){

        if (head == null || head.next == null) return;

        // 1. Find middle
        ListNode mid = findMiddle(head);

        // 2. Reverse second half
        ListNode second = invertList(mid.next);
        mid.next = null;              // 🔑 split the list

        // 3. Merge two halves
        ListNode first = head;

        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }

    private ListNode findMiddle(ListNode head) {

         ListNode slow = head;
         ListNode fast = head;

         while(fast!=null && fast.next!= null) {
             fast = fast.next.next;
             slow = slow.next;
         }

         return slow;
    }

    public ListNode invertList(ListNode head) {

         ListNode prev = null;
         ListNode temp = new ListNode();

         while(head != null) {
             temp = head.next;
             head.next = prev;
             prev = head;
             head = temp;
         }

         return prev;
    }
}
