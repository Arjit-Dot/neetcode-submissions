class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int hash[]=new int[128];
        Arrays.fill(hash,-1);
        int start=0;
        int end=0;
        while(end<s.length())
        {
            char c=s.charAt(end);
            if(hash[c]>=start)
                start=hash[c]+1;
            max=Math.max(end-start+1,max);
            hash[c]=end;
            end++;
        }
        return max;
    }
}
