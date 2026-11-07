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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode dummy=head;
        boolean carryOver=false;
        while(l1!=null && l2!=null){
            int sum=l1.val+l2.val;
            if(carryOver) sum++;
            if(sum>=10){
                dummy.next=new ListNode(sum%10);
                carryOver=true;
            }
            else{
                dummy.next=new ListNode(sum);
                carryOver=false;
            }
            dummy=dummy.next;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            int sum=l1.val;
            if(carryOver) sum++;
            else{
                dummy.next=l1;
                break;
            }
            if(sum>=10){
                dummy.next=new ListNode(sum%10);
            }
            else{
                dummy.next=new ListNode(sum);
                carryOver=false;
            }
            dummy=dummy.next;
            l1=l1.next;
        }
        while(l2!=null){
            int sum=l2.val;
            if(carryOver) sum++;
            else {
                dummy.next=l2;
                break;
            }
            if(sum>=10){
                dummy.next=new ListNode(sum%10);
            }
            else{
                dummy.next=new ListNode(sum);
                carryOver=false;
            }
            dummy=dummy.next;
            l2=l2.next;
        }
        if(carryOver) dummy.next=new ListNode(1);
        return head.next;

    }
}
