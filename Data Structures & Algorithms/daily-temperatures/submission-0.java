class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> stk = new Stack<>();
        // entry - new int[]{vailue, index};
        // access - stk.peek()[0] -> value and [1] for idx
        int[] result = new int[n];

        for(int i=0; i< n; i++){

            while(!stk.isEmpty() && stk.peek()[0] < temperatures[i] ){
                result[stk.peek()[1]] = i-stk.peek()[1];
                stk.pop();
            }


            // push done when no pop
            stk.push(new int[]{temperatures[i],i}) ;
        }

        return result;

    }
}
