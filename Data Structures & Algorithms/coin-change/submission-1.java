class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int size=coins.length;
        int dp[][]=new int[size][amount+1];
        for(int []i:dp){
            Arrays.fill(i,-2);
        }
       // return recur(coins,amount,0,0);
       return memo(coins,dp,amount,0);
    }
    public int recur(int []coins,int amount,int index,int sum){
        if(sum==amount)return 0;
        if(index==coins.length || sum>amount)return -1;
        int pick=recur(coins,amount,index,sum+coins[index])+1;
        int skip=recur(coins,amount,index+1,sum);
        if(pick>0 && skip >0)return Math.min(pick,skip);
        else if(pick>0 || skip>0){
            if(pick>0)return pick;
            else return skip;
        }
        else return -1;
    }
    public int memo(int []coins,int[][]dp,int amount,int index){
        if(amount==0)return 0;
        if(index==coins.length || amount<0)return -1;
        if(dp[index][amount]!=-2)return dp[index][amount];
        int pick=memo(coins,dp,amount-coins[index],index)+1;
        int skip=memo(coins,dp,amount,index+1);
        int ans;
        if(pick>0 && skip>0)ans=Math.min(pick,skip);
        else if(pick!=-1 || skip!=-1){
            if(pick>0) ans=pick;
            else ans=skip;
        }
        else ans=(-1);
        return dp[index][amount]=ans;
    }
}
