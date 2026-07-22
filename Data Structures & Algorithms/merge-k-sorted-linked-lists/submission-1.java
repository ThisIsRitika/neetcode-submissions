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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0) return null;

        for(int i=1;i<n;i++){
            lists[i]=mergeTwoLists(lists[i], lists[i-1]);
        }

        return lists[n-1];

    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode sorted=new ListNode();
        ListNode sortNext=sorted;
        ListNode head1;
        ListNode head2;
        if(list1.val<=list2.val){
            sorted.val=list1.val;
            head1=list1.next;
            head2=list2;
        }else{
            sorted.val=list2.val;
            head2=list2.next;
            head1=list1;
        }

        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                sortNext.next=head1;
                head1=head1.next;
            }else{
                sortNext.next=head2;
                head2=head2.next;
            }

            sortNext=sortNext.next;

        }

        while(head1!=null){
            sortNext.next=head1;
            head1=head1.next;
            sortNext = sortNext.next;
        }
        while(head2!=null){
            sortNext.next=head2;
            head2=head2.next;
            sortNext = sortNext.next;
        }

        return sorted;
    }
}
