class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        int left=0,right=0,count=t.length(),start_index=0,minFreq=Integer.MAX_VALUE;
        int arr[]=new int[128];
        for(int i=0;i<count;i++)
        {
            arr[t.charAt(i)]++;
        }
        while(right<s.length())
        {
            if(arr[s.charAt(right)]>0)
            {
                count--;
            }
            arr[s.charAt(right)]--;
            while(count==0)
            {
                int currFreq=right-left+1;
                if(currFreq<minFreq)
                {
                    minFreq=currFreq;
                    start_index=left;
                }
                arr[s.charAt(left)]++;
                if(arr[s.charAt(left)]>0)
                {
                    count++;
                }
                left++;
            }
            right++;
        }
        return (minFreq==Integer.MAX_VALUE)? "":s.substring(start_index,start_index+minFreq); 
    }
}
