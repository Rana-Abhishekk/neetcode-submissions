class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // approach -> keep the frequecy count in hashmap and then use a reverse bucket where index is the frequesny and value is the list of numbers that has it.

        // initializing map;
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        //putting values in the map frequncy tabel
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // initailize the bucket with indices as frequesy and value as list or arraylist.
        List<Integer>[] bucket = new List[n+1]; // size should be +1 as count start from 1.
        // initialize the bucket  with an arraylist as well as it initialises null 
        for(int i=0; i<=n; i++){
            bucket[i] = new ArrayList<>();
        }
        for(Integer key : map.keySet()){
            bucket[map.get(key)].add(key);
        }
        int[] result = new int[k];
        int idx = 0;
        for(int i=n; i>0 && idx < k; i--){
            if(bucket[i].size() != 0 && k > 0){
                for (int num : bucket[i]){
                    if(idx == k) break;
                    result[idx] = num;
                    idx++;
                }
                
            }
        }
        return result;
    }
}
