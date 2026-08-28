//import java.util.Hashmap;
class Solution
{   
    public String convertToAlporder(String str)
    {
        char arr[]=str.toCharArray();
        Arrays.sort(arr);
        String output=new String(arr);
        return output;
    }

    public String [] alpOrder(String [] strs)
    {
        String [] clone=strs.clone();
        for(int i=0;i<clone.length;i++)
        {
            clone[i]=convertToAlporder(clone[i]);
        }
        return clone;
    }
    public List<List<String>> groupAnagrams(String [] strs)
    {   
        List<List<String>> output=new ArrayList<>();
        String [] clone =alpOrder(strs);
        HashMap<String,ArrayList<String>> count=new HashMap<>();
        for(int i=0;i<clone.length;i++)
        {
            count.putIfAbsent(clone[i],new ArrayList<>());
            count.get(clone[i]).add(strs[i]);
        }
        for(String i: count.keySet())
        {
             output.add(count.get(i));
        }
        return output;
    }

}