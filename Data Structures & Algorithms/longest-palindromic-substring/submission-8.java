class Solution {
    public String longestPalindrome(String s) {
        if (s.length()<=1)return s;
        int maxLen=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            int odd=expandCenter(s,i,i);
            int even=expandCenter(s,i,i+1);
            int currMax=Math.max(odd,even);
            if(currMax>maxLen){
                maxLen=currMax;
                start=i-(currMax-1)/2;
            }
        }
        return s.substring(start,start+maxLen);
    }
    public int expandCenter(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
