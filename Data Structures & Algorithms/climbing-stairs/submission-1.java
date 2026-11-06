class Solution {
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        Arrays.fill(arr,-1);
        return memoClimb(n,arr);
       /* 
        return tableClimb(n,arr);
        return spaceOptimised(n); */
    }
    public  int recurClimb(int n){
        if(n<0)return 0;
        if(n==1 ||n==0) return 1;
        return recurClimb(n-2)+recurClimb(n-1);
    }
    public int memoClimb(int n,int arr[])
    {   if(n<0)return 0;
        if(n<=1)return 1;
        if(arr[n]!=-1) return arr[n];
        return arr[n]=memoClimb(n-1,arr)+memoClimb(n-2,arr);
    }
}
