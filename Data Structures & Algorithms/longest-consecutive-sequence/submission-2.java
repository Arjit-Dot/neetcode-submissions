

class Solution {
    public int longestConsecutive(int[] nums) {
        // Base case: empty array
        if (nums.length == 0) return 0;
        
        int[] clone = nums.clone();
        Arrays.sort(clone);
        
        int count = 1;
        int longest = 1;
        
        for (int i = 1; i < clone.length; i++) {
            // Trap 3: Skip duplicates completely
            if (clone[i] == clone[i - 1]) {
                continue; 
            }
            
            // If it is perfectly consecutive, increment
            if (clone[i] - clone[i - 1] == 1) {
                count++;
            } 
            // The sequence broke! 
            else {
                longest = Math.max(longest, count);
                count = 1; // Trap 2: Reset to 1, not 0
            }
        }
        
        // Final check in case the longest sequence ends at the very end of the array
        return Math.max(longest, count);
    }
}