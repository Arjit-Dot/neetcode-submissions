class Solution {

    public String encode(List<String> strs) {

        if(strs == null || strs.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> decoded = new ArrayList<>();

        int i = 0;
        while(i < str.length()){
            int delimiterIdx = str.indexOf('#', i);
            int strLength = Integer.parseInt(str.substring(i, delimiterIdx));
            int start = delimiterIdx + 1;
            int end = start + strLength;
            decoded.add(str.substring(start, end));
            i = end;
        }
        return decoded;
    }
}
