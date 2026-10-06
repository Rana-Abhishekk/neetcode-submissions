class Solution {
    public int findDuplicate(int[] nums) {
        // treat the array as a LL 
        int slow = 0;
        int fast = 0;

        // we will use index as values and nums[i] as pointers . 

        do{
            // move pointers 
            slow = nums[slow];
            fast = nums[nums[fast]]; // twon pointes movement
        }while(
            slow != fast
        );

        int p = 0 ; // to find the cycle index , which will be at slow ,

        while(p != slow){
            p = nums[p];
            slow = nums[slow]; // we move both p and slow to get hte start pint
        }
        return p;
    }
}
