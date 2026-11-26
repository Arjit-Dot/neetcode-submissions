class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix[]=new int [nums.length];
        int suffix[]=new int [nums.length];
        int prepod=1,suffpod=1;
        for(int i=0;i<nums.length;i++){
            prefix[i]=prepod;
            suffix[nums.length-1-i]=suffpod;
            prepod*=nums[i];
            suffpod*=nums[nums.length-1-i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=prefix[i]*suffix[i];
        }
        return nums;
    }
}  
