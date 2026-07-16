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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        int size=0;
        ListNode curr=head;

        while(curr!=null){
            size++;
            curr=curr.next;
        }

        ListNode ele=head;
        
        if(size==n) return head.next;

        for(int i=1;i<size-n;i++){
            ele=ele.next;
        }

        ListNode remove=ele.next;
        ele.next=remove.next;
        remove.next=null;

        return head;
    }
}
