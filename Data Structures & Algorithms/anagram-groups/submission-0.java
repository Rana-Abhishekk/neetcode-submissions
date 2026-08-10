class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> hm = new HashMap<>();
        // travertsing the array of string , sort the value found , use it as a key for hashmap and add teh real string as a value for that key, keep appending the values.
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            hm.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
        }

        // buyild trhe result
        List<List<String>> result = new ArrayList<>();
        for(String key : hm.keySet()){
            List<String> strList = hm.get(key);
            result.add(strList);
        }
        return result;
    }
}
