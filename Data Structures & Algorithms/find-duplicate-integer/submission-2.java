class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: The Race
        // Start both at index 0, taking their first respective steps
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while (slow != fast) {
            slow = nums[slow];           // 1 jump
            fast = nums[nums[fast]];     // 2 jumps
        }
        
        // Phase 2: Find the Cycle Entrance (The Duplicate)
        // Reset slow back to the start line
        slow = 0;
        
        while (slow != fast) {
            slow = nums[slow];           // 1 jump
            fast = nums[fast];           // 1 jump (fast slows down here!)
        }
        
        // The meeting point is the duplicate number
        return slow; 
    }
}