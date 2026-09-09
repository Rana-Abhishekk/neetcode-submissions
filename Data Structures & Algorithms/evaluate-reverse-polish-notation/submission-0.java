class Solution {
    public int evalRPN(String[] tokens) {
        // approach -> we will add values to the stack and then we come acroos a operator , pop two values from stack and apply operation to get result and add the value to stack.
        Stack<String> stk = new Stack();

        for (String ch : tokens) {
            if (ch.equals("+")) {
                int b = Integer.parseInt(stk.pop());
                int a = Integer.parseInt(stk.pop());
                stk.push(String.valueOf(a + b));
            } else if (ch.equals("-")) {
                int b = Integer.parseInt(stk.pop());
                int a = Integer.parseInt(stk.pop());
                stk.push(String.valueOf(a - b));
            } else if (ch.equals("*")) {
                int b = Integer.parseInt(stk.pop());
                int a = Integer.parseInt(stk.pop());
                stk.push(String.valueOf(a * b));
            } else if (ch.equals("/")) {
                int b = Integer.parseInt(stk.pop());
                int a = Integer.parseInt(stk.pop());
                stk.push(String.valueOf(a / b));
            } else {
                stk.push(ch);
            }
        }
        return Integer.parseInt(stk.pop());    }
}
