class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>out=new ArrayList<>();
        List<Integer>small=new ArrayList<>();
        add(nums,out,small,target,0);
        return out;
    }
    public void add(int[]nums,List<List<Integer>> out, List<Integer> small,int target,int index)
    {
        if(target==0)
        {
            out.add(new ArrayList<>(small));
            return;
            
        }
        if(target<0) return;
        for(int i=index;i<nums.length;i++)
        {   if(nums[i]>target)
            {
               return;
            }
            small.add(nums[i]);
            add(nums,out,small,target-nums[i],i);
            small.remove(small.size()-1);
        }
    }
}
