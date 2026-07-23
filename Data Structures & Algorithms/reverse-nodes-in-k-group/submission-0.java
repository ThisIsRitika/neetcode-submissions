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
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevGroupEnd=dummy;

        while(true){
            ListNode kth=prevGroupEnd;

            for(int i=0;i<k && kth!=null;i++){
                kth=kth.next;
            }

            if(kth==null) break;

            ListNode nextGroup=kth.next;
            ListNode prev=nextGroup;
            ListNode curr=prevGroupEnd.next;

            while(curr!=nextGroup){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }

            ListNode temp=prevGroupEnd.next;
            prevGroupEnd.next=kth;
            prevGroupEnd=temp;

        }

        return dummy.next;
    }
}
