class Solution {
    public int maxProfit(int[] prices) {
    int low=0;
    int high=low+1;
    int maxProfit=0;
    while(high<prices.length && low<prices.length)
    {
        if(prices[low]==prices[high] || low==high)
            high++;
        if(high<prices.length && prices[low]<prices[high])
        {   
            int newProfit=prices[high]-prices[low];
            maxProfit=Math.max(maxProfit,newProfit);
            high++;
        }
        else
        {
            low++;
        }

    }
    return maxProfit;
    }
}
