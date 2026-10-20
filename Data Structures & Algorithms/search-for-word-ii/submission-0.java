class Solution {
    private class Node{
        Node arr[];
        boolean isEnd;
        boolean visited;

    public Node(){
        arr=new Node[26];
    }}
    public Node root=new Node();

    public void add(String word){
        Node curr=root;
        int size=word.length();
        for(int i=0;i<size;i++){
            int index=word.charAt(i)-'a';
            if(curr.arr[index]==null) curr.arr[index]=new Node();
            curr=curr.arr[index];
        }
        curr.isEnd=true;
    
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Solution obj=new Solution();
        for(int i=0;i<words.length;i++){
            obj.add(words[i]);
        }
        List<String> output=new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                gridSearch(output,board,obj.root,new StringBuilder(),i,j);
            }
        }
        
        return output;
    }
    public void gridSearch(List<String>output,char[][]board,Node curr,StringBuilder string,int row, int col){    
        if(row==board.length || col==board[0].length || row<0 || col<0) return;
        if( board[row][col]=='*') return ;
        int index=board[row][col]-'a';
        if(curr.arr[index]==null ) return;
        char val=board[row][col];
            string.append(board[row][col]);
            curr=curr.arr[index];
            val=board[row][col];
            board[row][col]='*';
        if(curr.isEnd==true){
            output.add(new String(string));
            curr.isEnd=false;
        } 
        gridSearch(output,board,curr,string,row+1,col);
        gridSearch(output,board,curr,string,row-1,col);
        gridSearch(output,board,curr,string,row,col+1);
        gridSearch(output,board,curr,string,row,col-1);
        board[row][col]=val;
        if(string.length()>0)
        string.deleteCharAt(string.length()-1);
      
    }
        
}
