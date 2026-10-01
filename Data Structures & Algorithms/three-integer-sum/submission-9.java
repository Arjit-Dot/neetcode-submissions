
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array to enable the two-pointer technique and easily skip duplicates
        Arrays.sort(nums);
        
        // 2. Iterate through the array, treating nums[i] as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            
            // Skip duplicates for the first element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Use two pointers for the remaining part of the array
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second element (left pointer)
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    
                    // Skip duplicates for the third element (right pointer)
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers inward after finding a valid triplet
                    left++;
                    right--;
                    
                } else if (sum < 0) {
                    // Sum is too small, increment left pointer to increase the sum
                    left++;
                } else {
                    // Sum is too large, decrement right pointer to decrease the sum
                    right--;
                }
            }
        }
        
        return result;
    }
}