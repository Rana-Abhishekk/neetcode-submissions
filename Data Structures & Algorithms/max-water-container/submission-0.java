class Solution {
    public int maxArea(int[] heights) {
        // two pointer approach , where we take the leftmost nd rightmost point calculate its volume , then move the one with smaller height. if its equal we could move right one. It works because the smaller one can't produce a higher voulme than current. 
        int n = heights.length;
        int l = 0; int r = n-1; int max = Integer.MIN_VALUE; int vol = 0;

        while(l<r){
            vol = Math.min(heights[l], heights[r]) * (r-l);
            max = Math.max(max, vol);
            if(heights[l] < heights[r]){
                l++;
            }else if (heights[l] > heights[r]){
                r--;
            } else{
                l++;
            }
        }

        return max;

    }
}
