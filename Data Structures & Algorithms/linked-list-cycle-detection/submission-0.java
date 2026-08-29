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
    public boolean hasCycle(ListNode head) {
        ArrayList<ListNode> check=new ArrayList<>();
        while(head!=null)
        {
            if(check.contains(head))
                return true;
            else
            {
                check.add(head);
                head=head.next;
            }
                
        }
        return false;
    }
}
