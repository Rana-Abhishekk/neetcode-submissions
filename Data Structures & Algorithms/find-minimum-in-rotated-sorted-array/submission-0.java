class Solution {
    public int findMin(int[] nums) {
        // we can imagine it as a two part array , where we have to part1/part2 --> after rotation part2/part1 , we have to find first occurance of part1 , for that we know that part 2 guys would always be less than last (arraus last) index value with is last of part 1 as it was sorted array anyway ... idnums[mid] > nums[n-1] --> part 2 move to right and mid < nums[n-1] -> part 1 but move left after saving . 
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int res = -1;

        while(l<=h){
            int mid = l + (h-l)/2;

            if(nums[mid] > nums[n-1]){
                // part two move to left 
                l = mid+1;
            }else{
                res = mid;
                h = mid-1;
            }


        }
        return nums[res];


    }
}
