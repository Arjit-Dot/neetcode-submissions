class Solution {
    public int maxProfit(int[] prices) {
    int low=0;
    int high=low+1;
    int maxProfit=0;
    while(high<prices.length)
    {
        if(high<prices.length && prices[low]<prices[high])
        {   
            int newProfit=prices[high]-prices[low];
            maxProfit=Math.max(maxProfit,newProfit);
        }
        else
        {
            low=high;
        }
        high++;

    }
    return maxProfit;
    }
}
