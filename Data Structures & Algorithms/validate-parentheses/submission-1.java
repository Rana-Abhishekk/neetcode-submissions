class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()){
            
            if(!stk.isEmpty() && ch == ')' && stk.peek() == '('){
                stk.pop();
            }
            else if(!stk.isEmpty() && ch == '}' && stk.peek() == '{'){
                stk.pop();
            }
            else if(!stk.isEmpty() && ch == ']' && stk.peek() == '['){
                stk.pop();
            }else{

            




            //in no pop condition add the value of string
            stk.add(ch);
            }
        }

        if(stk.isEmpty()){
                return true;
            }else{
                return false;
            }

        
    }
}
