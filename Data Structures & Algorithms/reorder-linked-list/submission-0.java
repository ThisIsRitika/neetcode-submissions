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
    public void reorderList(ListNode head) {
        int size=0;
        ListNode curr=head;
        
        while(curr!=null){
            size++;
            curr=curr.next;
        }

        curr=head;

        for(int i=0;i<size/2;i++){
            ListNode tail=head;
            while(tail.next.next!=null){
                tail=tail.next;
            }
            ListNode tailTemp=tail.next;
            tail.next=null;
            ListNode temp=curr.next;
            curr.next=tailTemp;
            tailTemp.next=temp;
            
            curr=temp;
        }
    }
}
