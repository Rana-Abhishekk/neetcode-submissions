class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<n; i++){
            Character ch = s.charAt(i);
            if(i==0) {
                stk.push(ch); continue;
            }

            if(!stk.isEmpty() && ch == '}' && stk.peek() == '{'){
                stk.pop(); continue;
            }
            if(!stk.isEmpty() && ch == ']' && stk.peek() == '['){
                stk.pop(); continue;
            }
            if(!stk.isEmpty() && ch == ')' && stk.peek() == '('){
                stk.pop(); continue;
            }

            stk.push(ch);
            
        }
        if(stk.isEmpty()) {
            return true;
        } 

        return false;
    }
}
