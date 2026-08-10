class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> hm = new HashMap<>();
        // More optimised by using hashtable of array of 26 size and adding a frequecy as value of array indices by str - 'a' to nget indexes . and use htat as hashMap key , value would be list of string 
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            int[] key = new int[26];
            for(int j=0; j<str.length(); j++){
                key[str.charAt(j) - 'a'] = key[str.charAt(j) - 'a'] + 1;
            }
            String keyString = Arrays.toString(key);
            hm.computeIfAbsent(keyString, k -> new ArrayList<String>()).add(str);
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
