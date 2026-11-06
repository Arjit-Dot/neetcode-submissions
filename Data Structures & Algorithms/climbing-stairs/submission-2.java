class Solution {
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        Arrays.fill(arr,-1);
        return tableClimb(n,arr);
       /* 
        
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
    public int tableClimb(int n,int arr[]){
        arr[0]=arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}