class Solution {
    public int rob(int[] nums) {
        //return recur(nums,0);
        int [] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return memo(nums,dp,0);
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
    /*
    public int tabul(){

    }

    public int spaceOpt(){

    } */
}
