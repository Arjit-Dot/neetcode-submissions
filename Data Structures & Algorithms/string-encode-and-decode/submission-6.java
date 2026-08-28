class Solution {

    public String encode(List<String> strs) {
        StringBuilder output =new StringBuilder();
        for(String s :strs)
        {
            output.append(s.length()).append('#').append(s);
        }
    System.out.println(output.toString());
       return output.toString();
    }

    public List<String> decode(String str) {
        List <String>output =new ArrayList<>();
        int startIndex=0;
        int i=0;
        while(startIndex<str.length())
        {   

            int hashIndex=str.indexOf('#',startIndex);
            int size=Integer.parseInt(str.substring(startIndex,hashIndex));
            int startString=hashIndex+1;
            output.add(str.substring(startString,startString+size));
            startIndex=startString+size;
        }
        return output;
    }
}
