class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer>count=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(count.containsKey(nums[i]))
                return nums[i];
            count.put(nums[i],nums[i]);
        }
        return -1;
    }
}
