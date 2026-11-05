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
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int firstRes = 0;
        int secondRes = 0;

        ListNode curr1 = l1;
        int k1 = 1;
        int number1 = 0;

        ListNode curr2 = l2;
        int k2 = 1;
        int number2 = 0;

        while(curr1 != null) {
            number1=number1 + (k1 * curr1.val);
            k1 = k1*10;
            curr1 = curr1.next;
        }
        while(curr2 != null) {
            number2=number2 + (k2 * curr2.val);
            k2 = k2*10;
            curr2 = curr2.next;
        }

        int sum = number1 + number2;
        int copy = sum;
        int len = 0;


        ListNode prev = new ListNode(sum%10);
        sum = sum/10;
        ListNode dummy = prev;

        while(sum!=0) {
            ListNode newNode = new ListNode(sum%10);
            prev.next = newNode;
            prev = newNode;
            sum = sum/10;
        }

        return dummy;

    }
}
