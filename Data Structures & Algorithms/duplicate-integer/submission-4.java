class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer>exists=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(exists.containsKey(nums[i]))return true;
            exists.put(nums[i],0);
        }
        return false;
    }
}