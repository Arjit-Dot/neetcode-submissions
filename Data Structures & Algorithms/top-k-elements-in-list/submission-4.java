class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int hash[]=new int[(int)1e4+1];
        ArrayList<Integer> output=new ArrayList<>();
        for(int i:nums)
        {   
                hash[i+1000]+=1;
        }
        int count =k;
        while(count!=0)
        {
            int index=largest(hash);
            System.out.println(index);
            output.add(index-1000);
            count--;
        }
        int out[]=new int[output.size()];
        for(int i=0;i<output.size();i++)
        {
            out[i]=output.get(i);
        }
        return out;
        
    }
    public int largest(int [] hash)
    {
        int largest=0;
        for(int i=0;i<hash.length;i++)
        {
            if (hash[i]>hash[largest])
            {   
                largest=i;
            }
        }
        hash[largest]=0;
        return largest;
    }
}
