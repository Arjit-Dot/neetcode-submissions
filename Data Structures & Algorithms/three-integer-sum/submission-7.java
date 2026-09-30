
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the current number is > 0, the sum can never be 0
            if (nums[i] > 0) break;
            
            // Skip duplicates for the first number to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Step 3: Two pointers for the remaining array
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move both pointers inward
                    left++;
                    right--;
                    
                    // Skip duplicates for the second and third numbers
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } 
                else if (sum < 0) {
                    // Sum is too small, we need a larger number, move left pointer right
                    left++;
                } 
                else {
                    // Sum is too large, we need a smaller number, move right pointer left
                    right--;
                }
            }
        }
        
        return result;
    }
}