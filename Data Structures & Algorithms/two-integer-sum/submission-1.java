class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            if(hm.containsKey(nums[i])) return new int[]{hm.get(nums[i]), i};
            hm.put(target-nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
