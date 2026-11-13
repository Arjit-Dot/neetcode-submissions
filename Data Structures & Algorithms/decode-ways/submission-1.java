class Solution {
    public int numDecodings(String s) {
        int memo[]=new int[s.length()+1];
        Arrays.fill(memo,-1);
        return decode(s,memo,0);
    }
    public int decode(String s,int []memo,int index){
        if(index==s.length())return 1;
        if(s.charAt(index)-'0'==0)return 0;
        if(memo[index]!=-1)return memo[index];
        int ways=decode(s,memo,index+1);
        if(index+1<s.length()){
            int twoDigits=(s.charAt(index)-'0')*10+(s.charAt(index+1)-'0');
            if (twoDigits>=1 && twoDigits<=26){
                ways +=decode(s,memo,index+2);
            }
        }
        return memo[index]=ways;
    }
}
