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
    public int[] nextLargerNodes(ListNode head) {

        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        int[] ans = new int[n];

        temp = head;
        int i = 0;

        while (temp != null) {

            ListNode curr = temp.next;

            while (curr != null) {
                if (curr.val > temp.val) {
                    ans[i] = curr.val;
                    break;
                }
                curr = curr.next;
            }

            i++;
            temp = temp.next;
        }
        return ans;
    }
}
