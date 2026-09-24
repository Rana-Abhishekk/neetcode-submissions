class Solution {
    public int largestRectangleArea(int[] heights) {
    // try to build a monotonic stack where only heights is in ascending order , when a height less that the peek() occurs it is the right wall as all those larger than this which are in the stack will give the area . please make sure the last one extra will be of height 0 , height is calculated for the ones inside the stack the element in question is not part , so a zero height will do final clean up. we are keeping the left wall height in the stack.
    Stack<Integer> stk = new Stack<>();
    int max = 0;
    for(int i=0; i<= heights.length; i++){

        int element = (i == heights.length) ? 0 : heights[i]; // clean up duty in case the last element is not smaller than its counter parts.

        while(!stk.isEmpty() && element < heights[stk.peek()]){ // new height is less than then the height of index given.
        int h = heights[stk.pop()];
        int leftWall = stk.isEmpty() ? -1 : stk.peek(); 
        int width = i - leftWall - 1;
            max = Math.max(max, h*width);
        }

        stk.push(i); // the index is being pushed , tell us about the left wall that is safe to assume 


    }

    return max;

    }
}
