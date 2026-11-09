class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        // Universe A: Index 0 to length - 2
        int maxA = robLinear(nums, 0, nums.length - 2);
        // Universe B: Index 1 to length - 1
        int maxB = robLinear(nums, 1, nums.length - 1);
        
        return Math.max(maxA, maxB);
    }
    
    // This is the exact O(1) space House Robber 1 logic
    private int robLinear(int[] nums, int start, int end) {
        int rob = 0;
        int skip = 0;
        
        for (int i = start; i <= end; i++) {
            int currentMax = Math.max(nums[i] + skip, rob);
            skip = rob;
            rob = currentMax;
        }
        
        return rob;
    }
}