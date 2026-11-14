class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int size=coins.length;
        int dp[]=new int[size];
        Arrays.fill(dp,-1);
        return recur(coins,amount,0,0);
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
}
