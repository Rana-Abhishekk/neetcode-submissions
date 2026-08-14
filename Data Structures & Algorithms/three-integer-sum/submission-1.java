class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // we will use two points i will traverse theough the array , will have l as i+1 and r as the last one , if duplicates before i travese and same for l and r points , nums[i] = -(target) find the nums[l]+nums[r] .
        int n = nums.length;
        int l;
        int r;
        int target;
        for(int i=0; i<n; i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            l = i+1;
            r = n-1;
            target = -(nums[i]);

            while(l<r){
                if(nums[l] + nums[r] == target) {
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
            while (l < r && nums[l] == nums[l + 1]) l++;
            while (l < r && nums[r] == nums[r - 1]) r--;
            l++;r--;
            }else if(nums[l] + nums[r] < target){
                l++;
            }else{
                r--;
            }
        }
        }
        return res;
    }
}
