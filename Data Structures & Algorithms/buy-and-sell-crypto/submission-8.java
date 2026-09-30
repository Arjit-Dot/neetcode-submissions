class Solution {
    public int maxProfit(int[] prices) {
        int left=0;
        int right=left+1;
        int max=0;
        while(right<prices.length)
        {
            if(prices[left]< prices[right])
            {
                max=Math.max(max,prices[right]-prices[left]);
                right++;
            }
            else
            {
                left=right;
                right++;
            }
        }
        return max;
    }
}
