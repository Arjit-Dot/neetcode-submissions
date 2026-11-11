class Solution {
    int [][] memo=new int[1000][1000];
    public String longestPalindrome(String s) {
        int size=s.length();
        if(size==1)return s;
        for(int[]r:memo){
            Arrays.fill(r,-1);
        }
        if(isPalindrome(s,0,size-1))return s;
        int bigLen=0;
        int startIndex=0;
        
        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                if(isPalindrome(s,i,j)){
                    if(j-i+1>bigLen){
                    bigLen=j-i+1;
                    startIndex=i;
                    }
                    
                }
            }
        }
        return s.substring(startIndex,startIndex+bigLen);

    }
    private boolean isPalindrome(String s, int i, int j) {
    int start=i,end=j;
    while (start < end) {
        if(memo[i][j]==0) return false;
        else if(memo[i][j]==1)return true;

        if (s.charAt(start) != s.charAt(end)) {
            memo[start][end]=0;
            return false;
        }
        start++;
        end--;
    }
    memo[i][j]=1;
    return true;
}
}
