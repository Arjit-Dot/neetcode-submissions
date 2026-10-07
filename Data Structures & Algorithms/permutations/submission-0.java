class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out=new ArrayList<>();
        HashMap<Integer,Integer>hash=new HashMap<>();
        for(int i:nums)
            hash.put(i,1);
        findPermute(nums,out,new ArrayList<Integer>(),hash);
        return out;
    }
    private void findPermute(int []nums,List<List<Integer>> out,List<Integer>sample,HashMap<Integer,Integer>hash)
    {
        if(sample.size()==nums.length)
        {
            out.add(new ArrayList<>(sample));
           // hash.put(sample.get(sample.size()-1),1);
            //sample.remove(sample.size()-1);
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(hash.get(nums[i])==0) continue;
            hash.put(nums[i],0);
            sample.add(nums[i]);
            findPermute(nums,out,sample,hash);
            hash.put(nums[i],1);
            sample.remove(sample.size()-1);
        }
    }
}
