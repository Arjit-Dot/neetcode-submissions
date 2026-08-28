class Solution {
    public int evalRPN(String[] tokens) {
        int size = tokens.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < size; i++) {
            String c = tokens[i];

            if (!c.equals("+") && !c.equals("-") &&
                !c.equals("*") && !c.equals("/")) {

                int j = Integer.parseInt(c);
                stack.push(j);
            }
            else {
                int a, b;

                switch (c) {
                    case "+":
                        result = stack.pop() + stack.pop();
                        stack.push(result);
                        break;

                    case "-":
                        a = stack.pop();
                        b = stack.pop();
                        result = b - a;
                        stack.push(result);
                        break;

                    case "*":
                        result = stack.pop() * stack.pop();
                        stack.push(result);
                        break;

                    case "/":
                        a = stack.pop();
                        b = stack.pop();
                        result = b / a;
                        stack.push(result);
                        break;
                }
            }
        }

        return stack.pop();
    }
}