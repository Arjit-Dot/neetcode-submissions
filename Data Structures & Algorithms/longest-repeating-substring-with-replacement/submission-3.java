class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length()==0) return 0;
        int maxLength=0;
        int hash[]=new int[26];
        int start=0;
        int end=0;
        int maxFreq=0;
        //maxReplacaement =maxLength-maxFreq
        while(end<s.length())
        {   
            int index=s.charAt(end)-'A';
            maxFreq=Math.max(maxFreq,++hash[index]);
            int currLength=end-start+1;
            int replacements=currLength-maxFreq;
            if(replacements<=k)
                maxLength=Math.max(currLength,maxLength);
            else
            {   int currFreq=hash[index];
                while((end-start+1)-maxFreq>k)
                {
                    hash[s.charAt(start)-'A']--;
                    start++;
                }
            }
            end++;
        }
        return maxLength;
    }
}
