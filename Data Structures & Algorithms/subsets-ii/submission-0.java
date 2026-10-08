class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>out=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,out,new ArrayList<>(),0);
        return out;
    }
    private void backtrack(int nums[],List<List<Integer>>out,List<Integer>sample,int index)
    {
        out.add(new ArrayList<>(sample));
        for(int i=index;i<nums.length;i++)
        {   
            if(i>index && nums[i-1]==nums[i]) continue;
            sample.add(nums[i]);
            backtrack(nums,out,sample,i+1);
            sample.remove(sample.size()-1);
        }
    }
}
