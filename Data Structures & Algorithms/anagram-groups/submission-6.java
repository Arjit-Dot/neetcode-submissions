class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hashMap=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char word[]=strs[i].toCharArray();
            Arrays.sort(word);
            hashMap.computeIfAbsent(new String(word), key -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(hashMap.values());
    }

}
