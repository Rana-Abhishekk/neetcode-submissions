class Solution {
    public int search(int[] nums, int target) {
          // we have to search in rotated sorted   array.
        // we know about the fact that we can always find find if the number belongs to part1 or part part 2 

        // there are different movements when something is in part 1 or 2 we just have to maove mid accordingly 

        // 4 , 5 , 1 ,2 ,3 --> If any element is greater than nums[nums.length-1] it is in part 1 and if not its in part 2 .
        // if element in part 1 decide the movements
        // part 1  we decide the movements in part 1 and 2 on the basisi of first and last element comparision. 

        int lo = 0;
        int n = nums.length;
        int hi = n-1;
        int res = -1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            // equal comparision 
            if(nums[mid] == target) return mid;

            // part 1 and part 2 movements are different 
            if(nums[mid] > nums[n-1]){
                // part 1 movements 
                if(nums[mid] > target){
                    // we have to find smaller and elements smaller are on both sides 
                    if(target < nums[0]) {
                        // if target is smaller we move to right 
                        lo = mid + 1;
                    } else{
                        hi = mid - 1;
                    }
                } else{
                    // if nums[mid] < target all larger elements are in right so move right
                    lo = mid+1;
                }

            }else{
                // part 2 movements
                if(nums[mid] > target){
                    // we have to find a smaller numner and that is always in the left 
                    hi = mid-1;
                }else{
                    // nums[mid] < target we have to find greater no. which is on both sides.
                    // we can use nums[n-1 fro movement of search]
                    if(target > nums[n-1]){
                        // we will move left 
                        hi = mid-1;
                    } else{
                        lo = mid+1;
                    }
                }
            }
        }
        return res;
    }
}
