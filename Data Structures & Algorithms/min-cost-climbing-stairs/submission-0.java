class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //return recurCost(cost.length,cost);
        int dp[]=new int[cost.length+1];
        Arrays.fill(dp,-1);
        return memoClimb(cost.length,cost,dp);
    }
    public int recurCost(int n,int arr[]){
        if(n<0) return Integer.MAX_VALUE;
        if(n<=1) return arr[n];
        if(n<arr.length)
        return arr[n]+Math.min(recurCost(n-1,arr),recurCost(n-2,arr));
        else 
            return Math.min(recurCost(n-1,arr),recurCost(n-2,arr));
    }
    public int memoClimb(int n,int arr[],int dp[]){
        if(n<0) return Integer.MAX_VALUE;
        if(n<=1) return arr[n];
        if(dp[n]!=-1)return dp[n];
        if(n<arr.length)
        return dp[n]=arr[n]+Math.min(memoClimb(n-1,arr,dp),memoClimb(n-2,arr,dp));
        else 
            return Math.min(memoClimb(n-1,arr,dp),memoClimb(n-2,arr,dp));
    }
}
