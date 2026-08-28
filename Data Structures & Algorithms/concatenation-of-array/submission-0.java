class Solution {
    public int[] getConcatenation(int[] nums) {
        int size=nums.length;
        if(size==0)
        {
            return new int[]{};
        }
        int output[]= new int[size*2];
        int index=0;
        while(index!=size*2)
        {
            for(int i=0;i<nums.length;i++)
            {
                output[index++]=nums[i];
            }
        }
        return output;
    }
}