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
        if(lists.length==0)return null;
        ListNode head=new ListNode();
        ListNode dummy=head;
        PriorityQueue<ListNode>minHeap=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
            minHeap.add(lists[i]);
        }
        while(!minHeap.isEmpty()){
            dummy.next=minHeap.poll();
            dummy=dummy.next;
            if(dummy.next!=null)
            minHeap.add(dummy.next);
        }
        return head.next;
    }
}
