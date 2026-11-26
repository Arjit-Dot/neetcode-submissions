class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==1 && !isOp(tokens[0])) return Integer.parseInt(tokens[0]);
        Deque<Integer>stack=new ArrayDeque<>();
        int first,second;
        for(int i=0;i<tokens.length;i++){
            if(isOp(tokens[i]) && !stack.isEmpty()){
                second=stack.pop();
                first=stack.pop();
                stack.push(arith(first,second,tokens[i]));
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
    public boolean isOp(String s){
        if (s.length()>1)return false;
        return !Character.isDigit(s.charAt(0));
    }
    public int arith(int l,int r,String op){
        switch(op){
        case "+":
            return l+r;
        case "-":
            return l-r;
        case "/":
            return l/r;
        case "*":
            return l*r;
        }
        return 0;
    }
}
