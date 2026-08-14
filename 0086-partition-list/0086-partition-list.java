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
    public ListNode partition(ListNode head, int x) {

        ListNode smallHead = null;
        ListNode smallTail = null;

        ListNode largeHead = null;
        ListNode largeTail = null;

        ListNode temp = head;

        while (temp != null) {

            if (temp.val < x) {

                if (smallHead == null) {
                    smallHead = temp;
                    smallTail = temp;
                } else {
                    smallTail.next = temp;
                    smallTail = temp;
                }

            } else {

                if (largeHead == null) {
                    largeHead = temp;
                    largeTail = temp;
                } else {
                    largeTail.next = temp;
                    largeTail = temp;
                }
            }

            temp = temp.next;
        }

        if (largeHead == null) {
            return smallHead;
        }

        if (smallHead == null) {
            return largeHead;
        }

        smallTail.next = largeHead;

        largeTail.next = null;

        return smallHead;
    }
}