class MinStack {
    long min;
    Stack<Long> stk; // as it can gold -intmax-intmac

    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(!stk.empty()){
            stk.push((long)val-min);
            if(val-min<0) min = val;
        }else{
            min = val;
            stk.push(0L);
        }
    }
    
    public void pop() {
        long val = stk.pop();
        if(val<0){
            // min has changed and min is the value
            min = min-val;
        }
    }
    
    public int top() {
        long val = stk.peek();
        if(val<0){
            // min has changed and min is the value
            return (int)min;
        } else {
            return (int)(val+min);
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}
