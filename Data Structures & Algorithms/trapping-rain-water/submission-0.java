class Solution {
    public int trap(int[] height) {
        // Base case: if the array is empty, no water can be trapped
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        
        int maxLeft = height[left];
        int maxRight = height[right];
        int capacity = 0;
        
        while (left < right) {
            // We always process the side with the smaller maximum boundary
            if (maxLeft < maxRight) {
                left++;
                // Update the maximum wall seen so far from the left
                maxLeft = Math.max(maxLeft, height[left]);
                // Add the trapped water resting on the current block
                capacity += maxLeft - height[left];
            } else {
                right--;
                // Update the maximum wall seen so far from the right
                maxRight = Math.max(maxRight, height[right]);
                // Add the trapped water resting on the current block
                capacity += maxRight - height[right];
            }
        }
        
        return capacity;
    }
}