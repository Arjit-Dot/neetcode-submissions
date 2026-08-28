public class Solution{
    public boolean isAnagram(String s, String t) {
    if(s.length()!=t.length())
        return false;
    char [] left=s.toCharArray();
    char[] right=t.toCharArray();
    Arrays.sort(left);
    Arrays.sort(right);
    for(int i=0;i<left.length;i++)
    {
        if(left[i]==right[i])
            continue;
        else
            return false;

    }
    return true;
}
}
