class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>out=new ArrayList();
        if(digits.length()<1) return out;
        backtrack("",digits,out);
        return out;
    }
    public void backtrack(String pro,String unpro,List<String>out){
        if(unpro.length()==0){
            out.add(pro);
            return;
        }
        int digit=unpro.charAt(0)-'0';
        int start=(digit-2)*3;
        if (digit == 8 || digit == 9) {
    start += 1;
}
        int end=(digit==9 || digit==7)?start+3:start+2;
        for(int i=start;i<=end;i++){
            char c=(char) (i+'a');
            backtrack(pro+c,unpro.substring(1),out);
        }
    }
}
