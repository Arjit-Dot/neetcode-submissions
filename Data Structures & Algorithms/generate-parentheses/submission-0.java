class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>out=new ArrayList<>();
        backtrack(out,new StringBuilder(),0,0,n);
        return out;
    }
    private void backtrack(List<String>out,StringBuilder pat,int open,int close,int n){
        if (open==n && close==n) 
        {
            out.add(new String(pat));
            return;
        }
        if(open<n)
        {
            pat.append('(');
            backtrack(out,pat,open+1,close,n);
            pat.deleteCharAt(pat.length()-1);
        }
        if(close<open)
        {
            pat.append(')');
            backtrack(out,pat,open,close+1,n);
            pat.deleteCharAt(pat.length()-1);
        }
    }
}
