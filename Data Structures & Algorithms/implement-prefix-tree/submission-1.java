class PrefixTree {
    private class Node{
        boolean isEnd;
        Node hash[];
    
    public Node(){
        hash=new Node[26];
    }
    }
    Node root;
    
    public PrefixTree() {
        root=new Node();
    }

    public void insert(String word) {
        int size=word.length();
        Node curr=root;
        word=word.toLowerCase();
        for(int i=0;i<size;i++)
        {   int index=word.charAt(i)-'a';
            if(curr.hash[index]==null)
            {
                curr.hash[index]=new Node();
            }
            curr=curr.hash[index];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        Node curr=root;
        int size=word.length();
        for(int i=0;i<size;i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.hash[index]==null) return false;
            curr=curr.hash[index];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr=root;
        int size=prefix.length();
        for(int i=0;i<size;i++)
        {
            int index=prefix.charAt(i)-'a';
            if(curr.hash[index]==null) return false;
            curr=curr.hash[index];
        }
        return true;
    }
}
