class Solution {
    public String minWindow(String s, String t) {
        if (s.length()<t.length()) return "";
        String out=new String();
        int start=0,end=0,minLength=Integer.MAX_VALUE,currTally=0,maxTally=t.length(), minStart=0;
        int hash[]=new int[128];
        for(char c: t.toCharArray())
        {
            hash[c]++;
        }
        while(end<s.length())
        {
            char c=s.charAt(end);
            if(hash[c]>0)
            {   
                currTally++;
            }
            hash[c]--;
            
            while(currTally == maxTally) {
    // 1. Record the valid window (only updating variables, no strings!)
    if (end - start + 1 < minLength) {
        minLength = end - start + 1;
        minStart = start;
    }
    
    // 2. Process the character leaving the window
    char n = s.charAt(start);
    hash[n]++;
    if (hash[n] > 0) {
        currTally--;
    }
    
    // 3. Shrink
    start++;
}
            
            end++;
        }

        return (minLength==Integer.MAX_VALUE)? "":s.substring(minStart,minStart+minLength);
    }
}