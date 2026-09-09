class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,maxLength=0,maxFreq=0;
        int hash[]=new int[26];
        for(int end=0;end<s.length();end++)
        {
            int index=s.charAt(end)-'A';
            hash[index]++;
            maxFreq=Math.max(maxFreq,hash[index]);
            if((end-left+1)-maxFreq<=k)
                maxLength=Math.max(maxLength,end-left+1);
            while((end-left+1)-maxFreq>k)
            {
                hash[s.charAt(left)-'A']--;
                left++;
            }
        }
        return maxLength;
    }
}
