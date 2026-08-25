class Solution {
    public int trap(int[] height) {
        // we can do it without the prefix adn suffix array we could rememeber leftmax and right max , smaller of both willl be hte cap for water. 
        int n = height.length;
        int l = 0; 
        int r = n-1;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int min = 0 ; int sum = 0 ; int res =0; int i =0 ; 
        while (l < r) {
            leftMax = Math.max(height[l], leftMax);
            rightMax = Math.max(height[r], rightMax);

            if (leftMax >= rightMax) {
                res += rightMax - height[r];
                r--;
            } else {
                res += leftMax - height[l];
                l++;
            }
        }
        return res;
    }
}
