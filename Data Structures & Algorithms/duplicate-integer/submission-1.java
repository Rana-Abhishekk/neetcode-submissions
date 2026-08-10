class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(hs.contains(nums[i])) return true;
            else {
                hs.add(nums[i]);
            }
        }
        return false;
    }
}