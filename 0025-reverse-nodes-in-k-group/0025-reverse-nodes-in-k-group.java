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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }

        ListNode temp=head;
        ListNode prevGroupEnd=null;
        while(temp!=null){
            ListNode kth=temp;
            for(int i=1;i<k;i++){
                if(kth==null){
                    return head;
                }
                kth=kth.next;
            }
            if(kth==null){
                return head;
            }
            ListNode nextGroup=kth.next;

            ListNode prev=nextGroup;
            ListNode curr=temp;

            while(curr!=nextGroup){
                ListNode next=curr.next;

                curr.next=prev;
                prev=curr;
                curr=next;
            }
            if(temp==head){
                head=kth;
            }
            else{
                prevGroupEnd.next=kth;
            }
            prevGroupEnd=temp;

            temp=nextGroup;
        }
        return head;
    }
}