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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prevGroup=head;
        ListNode current=head.next;

        int groupSize=2;

        while(current!=null){
            ListNode temp=current;
            int count=0;

            while(temp!=null && count<groupSize){
                count++;
                temp=temp.next;
            }
            if(count%2==0){
                ListNode  prev=temp;
                ListNode curr=current;

                for(int i=0;i<count;i++){
                    ListNode next=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=next;
                }
                prevGroup.next=prev;

                prevGroup=current;
                current=temp;
            }else{
                for(int i=0;i<count;i++){
                    prevGroup=current;
                    current=current.next;
                }
            }
            groupSize++;
        }
        return head;
    }
}