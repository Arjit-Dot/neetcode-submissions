class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int size=temp.length;
        int output[]=new int[size];
        for (int i=0;i<size-1;i++)
        {   
            for(int j=i+1;j<size;j++)
            {
                if(temp[j]>temp[i])
                {
                    output[i]=j-i;
                    break;
                }
            }
        }
        return output;
    }
}
