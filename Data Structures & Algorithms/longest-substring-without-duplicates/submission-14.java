class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[]=new int[128];
        Arrays.fill(hash,-1);
        int left=0;
        int right=0;
        int maxLength=0;
        while(right<s.length())
        {   char c=s.charAt(right);
            if(hash[c]>=left)
                left=hash[c]+1;
            hash[c]=right;
            maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
         return maxLength;
    }  
}
