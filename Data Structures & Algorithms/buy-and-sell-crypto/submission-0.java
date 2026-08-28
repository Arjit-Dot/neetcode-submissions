class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length;i++)
        {
            int bigger=biggest(prices,i);
            if(bigger==i)
            {
                continue;
            }
            else
            {
                profit=Math.max(profit,(prices[bigger]-prices[i]));
            }
        }
        return profit;
    }
    public int smallest(int [] arr, int low)
    {
        int small=low;
        for(int i=low+1;i<arr.length;i++)
        {
            if(arr[i]<arr[small])
            {
                small=i;
            }
        }
        return small;
    }
    public int biggest(int [] arr,int index)
    {
        int big=index;
        for(int i=big;i<arr.length;i++)
        {
            if(arr[i]>arr[big])
            {
                big=i;
            }
        }
        return big;
    }
}
