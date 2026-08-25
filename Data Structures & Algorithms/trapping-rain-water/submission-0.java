class Solution {
    public int trap(int[] height) {
        // We could use something like product of array , by creating a prefix and suffix array where prefix would store the heighest point to the left and suffix to the right , this way i can find the the area used by each indices for water collection and use its sum . 
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        // now initialise variables required.
        int res = 0;
        int sum = 0;
        int max = 0;
        // we will populate the pre and suf array with height element at left and right respectively.
        // populating first indices for pre and suf 
        pre[0] = height[0];
        suf[n-1] = height[n-1];
        for(int i=1; i<n; i++){
            max = Math.max(height[i], pre[i-1]);
            pre[i] = max;
        }
        max = 0;
        for(int i = n-2; i>=0; i--){
            max = Math.max(height[i], suf[i+1]);
            suf[i] = max;
        }

        // now the array is populated , we can do a signle traversal to find the volume stored at each index, by calculating the minimun of index for pre and suf as that caps water and substracting the value of height
        // sum = Math.min(pre[i], suf[i]) - height[i];
        // if(sum<0) sum = 0; res = sum+res;

        for(int i=0; i<n; i++){
            sum = 0;
            sum = Math.min(pre[i], suf[i]) - height[i];
            if(sum<0) sum = 0;
            res = sum+res;
        }

        return res;

    }
}
