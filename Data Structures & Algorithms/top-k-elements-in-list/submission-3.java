class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                // initializing map;
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        //putting values in the map frequncy tabel
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // adding the data into a list of array then sort list with a comparator 
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(new int[] {entry.getValue(), entry.getKey()});
        }

        list.sort((a , b) -> b[0] - a[0]); //ascending order as if value negative b comes first , if positive a comes first but this can cause issue with unbounded values. in that case should use comparingInt(a[0]).. 
        int [] res = new int[k];
        for(int i = 0 ; i<k ; i++){
            res[i] = list.get(i)[1];
        }
        return res;
    }
}
