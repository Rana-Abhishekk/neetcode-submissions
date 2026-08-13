class Solution {
    public int[] productExceptSelf(int[] nums) {
        // we will maintain a pre and post array that will help us get he res array.
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];

        int num = 1; // will store product.

        for(int i=0; i<n; i++){
            if(i == 0) {
                pre[i] = 1;
            } else {
                num = num * nums[i-1];
                pre[i] = num;
            }
        }
        num = 1; 

        for(int i=n-1; i>=0; i--){
            if(i == n-1){
                post[i] = 1;
            } else {
                num = num * nums[i+1];
                post[i] = num;
            }
        }

        int[] res = new int[n];
        for(int i=0; i<n;i++){
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}  
