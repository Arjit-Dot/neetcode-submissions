class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        filter(new ArrayList<Integer>(),nums,result);
        return result;
    }

    private void filter(List<Integer>pro,int [] unpro,List<List<Integer>>output)
    {
        if(unpro.length==0)
       {
        output.add(pro);
        return;
       }
        filter(pro,Arrays.copyOfRange(unpro,1,unpro.length),output);
        List <Integer> temp=new ArrayList<>(pro);
        temp.add(unpro[0]);
        filter(temp,Arrays.copyOfRange(unpro,1,unpro.length),output);
        
    }
}
