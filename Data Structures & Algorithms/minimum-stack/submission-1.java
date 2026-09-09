class MinStack {
    long min;
    Stack<Long> stk;

    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int val) {
        if (stk.isEmpty()) {
            min = val;
        }
        stk.push((long) val - min);
        if (val < min) {
            min = val;
        }
    }

    public void pop() {
        long val = stk.pop();
        if (val < 0) {
            min = min - val;
        }
    }

    public int top() {
        long val = stk.peek();
        if (val < 0) {
            return (int) min;
        }
        return (int) (val + min);
    }

    public int getMin() {
        return (int) min;
    }
}