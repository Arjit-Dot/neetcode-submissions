
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Append length, then delimiter, then the string itself
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // Find the position of the next delimiter starting from index i
            int hashIndex = str.indexOf('#', i);
            
            // Extract the length of the upcoming string
            int length = Integer.parseInt(str.substring(i, hashIndex));
            
            // The actual string starts right after the '#'
            int startOfStr = hashIndex + 1;
            
            // Extract the string using the parsed length
            String decodedStr = str.substring(startOfStr, startOfStr + length);
            output.add(decodedStr);
            
            // Move the pointer 'i' to the start of the next encoded chunk
            i = startOfStr + length;
        }
        
        return output;
    }
}