class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> count = new HashMap<>();
        
        for (String s : strs) {
            // 1. Sort the string on the fly
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            
            // 2. Group it directly into the map
            count.putIfAbsent(key, new ArrayList<>());
            count.get(key).add(s);
        }
        
        // 3. Return map values as a list
        return new ArrayList<>(count.values());
    }
}