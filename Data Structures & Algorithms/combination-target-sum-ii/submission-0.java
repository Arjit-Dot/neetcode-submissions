class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output=new ArrayList<>();
        Arrays.sort(candidates);
        add(candidates,target,output,new ArrayList<Integer>(),0);
        return output;
    }
    public void add(int [] cand, int target, List<List<Integer>> output,List<Integer>sample,int index)
    {
        if(index>cand.length) return;
        if(target==0)
        {
            output.add(new ArrayList<>(sample));
            return;
        }
        for(int i=index;i<cand.length;i++)
        {
            if(cand[i]>target) return;
            sample.add(cand[i]);
            add(cand,target-cand[i],output,sample,i+1);
            sample.remove(sample.size()-1);
            while(i<cand.length-1 && cand[i]==cand[i+1])
            {
                i++;
            }
        }
    }
}
