class Solution {
    public ListNode doubleIt(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        curr = head;
        int carry = 0;

        while (curr != null) {

            int sum = curr.val * 2 + carry;

            curr.val = sum % 10;
            carry = sum / 10;

            if (curr.next == null) {

                if (carry > 0) {
                    curr.next = new ListNode(carry);
                }

                break;
            }

            curr = curr.next;
        }

        prev = null;
        curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}