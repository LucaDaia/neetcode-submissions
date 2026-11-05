class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find middle
        ListNode middle = getMiddle(head);

        // 2. Reverse second half
        ListNode second = middle.next;
        middle.next = null;               
        second = invertList(second);

        // 3. Merge
        mergeLists(head, second);
    }

    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;   
        }
        return slow;
    }

    public ListNode invertList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public void mergeLists(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode t1 = head1.next;
            ListNode t2 = head2.next;

            head1.next = head2;
            head2.next = t1;

            head1 = t1;
            head2 = t2;
        }
    }
}
