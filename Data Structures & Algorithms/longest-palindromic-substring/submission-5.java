class Solution {
    public String longestPalindrome(String s) {
        int size=s.length();
        if(size==1)return s;
        if(isPalindrome(s,0,size-1))return s;
        int bigLen=0;
        int startIndex=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
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
    private boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
        if (s.charAt(start) != s.charAt(end)) return false;
        start++;
        end--;
    }
    return true;
}
}
