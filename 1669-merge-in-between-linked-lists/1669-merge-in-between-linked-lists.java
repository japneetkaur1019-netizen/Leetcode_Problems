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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode prev = list1;

        for (int i = 0; i < a - 1; i++) {
            prev = prev.next;
        }

        ListNode after = list1;

        for (int i = 0; i <= b; i++) {
            after = after.next;
        }

        ListNode last = list2;

        while (last.next != null) {
            last = last.next;
        }

        prev.next = list2;

        last.next = after;

        return list1;
    }
}