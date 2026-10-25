class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>out=new ArrayList<>();
        backtrack(s,out,new ArrayList<String>(),0);
        return out;
    }
    private void backtrack(String s, List<List<String>>out,List<String>temp,int index){
        if(index==s.length()){
            out.add(new ArrayList<>(temp));
            return;}
        for(int i=index;i<s.length();i++){
            String small=s.substring(index,i+1);
            if(isPalindrome(small)){
                temp.add(small);
                backtrack(s,out,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        if(s.length()==1) return true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))return false;
        }
        return true;
    }
}
