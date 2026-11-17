class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)return false;
        Set <Character> open=new HashSet<>(List.of('{','(','['));
        HashMap<Character,Character> close=new HashMap<>(Map.of(
            '{','}',
            '(',')',
            '[',']'
        ));
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(open.contains(s.charAt(i))) stack.push(s.charAt(i));
            else if(!stack.isEmpty() && s.charAt(i)==close.get(stack.peek())) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
