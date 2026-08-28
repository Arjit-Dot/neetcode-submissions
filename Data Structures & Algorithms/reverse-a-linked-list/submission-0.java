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
        ArrayList<Integer> reversed=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null)
        {
            reversed.add(temp.val);
            temp=temp.next;
        }
        Collections.reverse(reversed);
        temp=head;
        for(int i: reversed)
        {
            if(temp!=null)
            {
                temp.val=i;
            }
            temp=temp.next;
        }
        return head;
    }
}
