class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        // We go up to heights.length to process the "dummy" 0 height at the end
        for (int i = 0; i <= heights.length; i++) {
            
            // If we are at the end, pretend the height is 0 to flush the stack
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            
            // If we find a shorter bar, we resolve the bars currently in the stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // The bar we are calculating the max area for
                int height = heights[stack.pop()];
                
                // The right boundary is `i`. 
                // The left boundary is the new top of the stack.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            
            // Push the current index to the stack
            stack.push(i);
        }
        
        return maxArea;
    }
}