class Solution {
    public boolean isValid(String s) {
        int size=s.length();
        Deque<Character> stack=new ArrayDeque<>();
        if(s.isEmpty())
            return true;
        
        if(size==1)
        {
            return false;
        }
        for(int i=0;i<size;i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
            {
                stack.push(s.charAt(i));
            }
            else if(stack.isEmpty())
            {
                return false;
            }
            else
            {
                char pop=s.charAt(i);
                if(stack.peek()=='(' && pop!=')' || stack.peek()=='[' && pop!=']' || stack.peek()=='{' && pop!='}')
                return false;
            stack.pop();
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}