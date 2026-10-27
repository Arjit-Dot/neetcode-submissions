class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle using Slow and Fast pointers
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = slow.next;
        slow.next = null; // Sever the tie between the two halves
        ListNode prev = null;
        
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // Step 3: Weave the two lists together
        ListNode first = head;
        second = prev; // 'prev' is the new head of the reversed second half
        
        while (second != null) {
            // Save the next nodes before rewriting pointers
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            
            // Link first to second, then second back to first's next
            first.next = second;
            second.next = tmp1;
            
            // Shift pointers forward for the next iteration
            first = tmp1;
            second = tmp2;
        }
    }
}