class Solution {
    public int lengthOfLongestSubstring(String s) {
        String sub=new String();
        int result=0;
        if(s.length()==0)
            return 0;
        if(sub.isEmpty())
        {
            sub=sub+s.charAt(0);
            result++;
        }
        int right=1;
        while(right<s.length())
        {   int check=sub.indexOf(s.charAt(right));
            if(check==-1)
            {
                sub=sub+s.charAt(right);
                right++;
                result=Math.max(result,sub.length());
            }
            else
            {   
                result=Math.max(result,sub.length());
                sub=sub.substring(check+1)+s.charAt(right);
                right++;
            }
        }
        return result;
    }
}
