class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length;)
        {
            for(int j=numbers.length-1;j>i;)
            {
                if(numbers[i]+numbers[j]==target)
                {
                    return new int[]{i+1,j+1};
                }
                else if(numbers[i]+numbers[j]<target)
                {
                    i++;
                }
                else
                    j--;
            }
        }
        return new int[]{-1,-1};
    }
}
