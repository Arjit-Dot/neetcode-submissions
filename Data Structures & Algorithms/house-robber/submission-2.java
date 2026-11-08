class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        //return recur(nums,0);
        int [] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return tabul(nums,dp);
        //return memo(nums,dp,0);
    }
    public int recur(int []nums,int currIndex){
        if(currIndex>=nums.length)return 0;
 return Math.max(nums[currIndex]+recur(nums,currIndex+2),recur(nums,currIndex+1));
    } 

    public int memo(int nums[],int dp[],int n){
        if(n>=nums.length)return 0;
        int add=0;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=Math.max(nums[n]+memo(nums,dp,n+2),memo(nums,dp,n+1));
    }
    public int tabul(int []nums,int []dp){
        int n=nums.length;
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    /*
    public int spaceOpt(){

    } */
}
