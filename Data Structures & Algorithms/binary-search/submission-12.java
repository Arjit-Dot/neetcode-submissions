class Solution {
    public int search(int[] nums, int target) {
        int size = nums.length;
        int low = 0;
        int high = size;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid==size)
            {
                return -1;
            }
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
