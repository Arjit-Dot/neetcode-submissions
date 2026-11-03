class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>out=new ArrayList<>();
        backtrack(out,n,0,0,new StringBuilder());
        return out;
    }
    public void backtrack(List<String>out,int n,int open,int close,StringBuilder add){
        if(open==n && close==n){
            out.add(new String(add));
            return;
        }
        if(open<n){
            add.append("(");
            backtrack(out,n,open+1,close,add);
            add.deleteCharAt(add.length()-1);
        }
        if(close<open){
            add.append(")");
            backtrack(out,n,open,close+1,add);
            add.deleteCharAt(add.length()-1);
        }
    }
}
