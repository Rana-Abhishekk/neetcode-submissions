class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stk = new Stack<>(); // Stack will have time calculated , and if time > stk.peek() --> means car will be another fleet and if time < stk.peek -> throw it as it will crash into the car and become a fleeet , the stack size will give us fleets. 

        // create an array of paire to hold position and speed and sort by position in descending as the car with higher speed at end will reach first . 
        int[][] arr = new int[position.length][2];
        for(int i=0; i<position.length; i++){
            arr[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(arr, (a,b)-> b[0] - a[0]); //sortuing arry in descending 
        double time;
        for(int i=0; i<position.length; i++){
            time = (double) (target-arr[i][0]) /  arr[i][1];
            // we will check if the time calcuated at a point in arr is more than the one inside stack meaning the new value is a new fleet .if not it gets merged or thrown .
            if(stk.isEmpty() || time > stk.peek()){
                stk.push(time);
            }

        }

        return stk.size();

    }
}
