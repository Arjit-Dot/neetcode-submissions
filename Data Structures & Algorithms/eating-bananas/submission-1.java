class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int size=piles.length;
        int low=1;
        int high=piles[0];
        int k=0;
        for(int i:piles)
        {
            high=Math.max(high,i);
        }
        while(low<=high)
        {   
            int rate=(low+high)/2;
            if(rateChecker(piles, h, rate))
            {
                k=rate;
                high=rate-1;
            }
            else
                low=rate+1;
        }
        return k;
    }
    public boolean rateChecker(int [] piles, int h, int rate)
    {   int hours=0;
        for(int i=0;i<piles.length;i++)
        {
            if(hours>h)
                return false;
            int diff=(int) Math.ceil((double) piles[i]/rate);
            hours+=diff;
        }
        if(hours<=h)
            return true;
        else
            return false;
    }
}
