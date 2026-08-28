class Solution {
    public int findMin(int[] nums) {
        int size=nums.length;
        int low=0;
        int high=size-1;
        while(low<=high)
        {   
            if(low==high)
                return nums[low];
            
            while(nums[high]<nums[low])
            {   
                int mid = low+(high-low)/2;
                if(nums[mid]>nums[high])
                {   
                    low=mid+1;
                }
                else
                {
                    low++;
                    high=mid;
                }
            }
            if(nums[high]>nums[low])
            {
                return nums[low];
            }
        }
        return 0;
    }
}

