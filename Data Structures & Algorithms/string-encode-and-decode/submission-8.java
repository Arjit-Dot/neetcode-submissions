class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty())return "";
        StringBuilder out=new StringBuilder();
        for(String s:strs){
            out.append(s.length()).append('#').append(s);
        }
        return out.toString();
    }

    public List<String> decode(String str) {
        List<String>out=new ArrayList<>();
        if(str==null)return  out;
        int i=0;
        while(i<str.length()){
            int deLim=str.indexOf("#",i);
            int len=Integer.parseInt(str.substring(i,deLim));
            int wordStart=deLim+1;
            int wordEnd=wordStart+len;
            out.add(str.substring(wordStart,wordEnd));
            i=wordEnd;
        }
        return out;
    }
}
