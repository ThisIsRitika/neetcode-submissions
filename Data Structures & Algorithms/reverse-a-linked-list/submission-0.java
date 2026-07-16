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
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;

        while(curr!=null){
            //store the next node
            next=curr.next;
            //point to the previous node
            curr.next=prev;
            //curr becomes previous for the next node
            prev=curr;
            //next node becomes the current for the next iteration
            curr=next;
        }

        return prev;
        
    }
}
