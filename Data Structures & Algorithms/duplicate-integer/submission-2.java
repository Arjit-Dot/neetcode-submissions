class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> count=new HashMap<>();
        for(int i:nums)
        {
            if(count.putIfAbsent(i,1)==null)
                continue;
            else
                return true;
        }
        return false;
    }
}