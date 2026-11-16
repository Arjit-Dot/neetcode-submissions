class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;
        Deque<String>queue=new ArrayDeque<>();
        Set<String>hashSet=new HashSet<>(wordList);
        Set<String>visited=new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String curr=queue.poll();
                if(curr.equals(endWord))return level;
                for(int j=0;j<curr.length();j++){
                    char pieces[]=curr.toCharArray();
                    char og=pieces[j];
                    for(char c='a';c<='z';c++){
                        if(c==og)continue;
                        pieces[j]=c;
                        String replace=new String(pieces);
                        if(!visited.contains(replace)&& hashSet.contains(replace)){
                            queue.add(replace);
                            visited.add(replace);
                        }
                    }
                }
                
            }
            level++;
        }
        return 0;
    }
}
