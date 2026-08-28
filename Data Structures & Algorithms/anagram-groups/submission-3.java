//import java.util.Hashmap;
class Solution
{   public String[] sorted(String [] strs)
    {   
        String [] output=new String[strs.length];
        for(int i=0;i<strs.length;i++)
        {
            output[i]=sortString(strs[i]);
        }
        return output;
    }
    public String sortString(String str)
    {
        char [] output=str.toCharArray();
        Arrays.sort(output);
        return new String(output);
    }
    public List<List<String>> groupAnagrams(String [] strs)
    {   
       String clone[]=sorted(strs);
       List<List<String>> output=new ArrayList<>();
       HashMap<String,ArrayList<String>> count=new HashMap<>();
       for(int i=0;i<strs.length;i++)
       {
        count.putIfAbsent(clone[i],new ArrayList<>());
        count.get(clone[i]).add(strs[i]);
       }
       for(List<String> i: count.values())
       {
        output.add(i);
       }
       return output;
    }

}