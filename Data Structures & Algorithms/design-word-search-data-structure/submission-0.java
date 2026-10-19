class WordDictionary {
    private class Node{
        Node hash[];
        boolean isEnd;

    public Node()
    {
        hash=new Node[26];    
    }
    }
    Node root;
    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {
        int size=word.length();
        Node curr=root;
        for(int i=0;i<size;i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.hash[index]==null) curr.hash[index]=new Node();
            curr=curr.hash[index];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return backtrack(word,root,0);
    }
    private boolean backtrack(String word,Node curr,int index){
        if(index==word.length()) return curr.isEnd;
        if(word.charAt(index)=='.'){
            for(int i=0;i<curr.hash.length;i++)
            {
            if(curr.hash[i]==null) continue;
            if(backtrack(word,curr.hash[i],index+1))
            return true;
            }
        }
        else{
            if(curr.hash[word.charAt(index)-'a']==null) return false;
            else{
                curr=curr.hash[word.charAt(index)-'a'];
                return backtrack(word,curr,index+1);
            }
        }
        return false;
        
    }
    
}
