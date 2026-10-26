/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node ==null)return null;
        HashMap<Node,Node>hash=new HashMap<>();
        Node temp=new Node(node.val);
        hash.put(node,temp);
        cloning(node,hash);
        return hash.get(node);
    }
    private void  cloning(Node node,HashMap<Node,Node>hash){
        for(Node i:node.neighbors){
            if(!hash.containsKey(i)){
                Node temp=new Node(i.val);
                hash.put(i,temp);
                cloning(i,hash);
                hash.get(node).neighbors.add(temp);
            }
            else{
                hash.get(node).neighbors.add(hash.get(i));
            }
            
        }
    }
}