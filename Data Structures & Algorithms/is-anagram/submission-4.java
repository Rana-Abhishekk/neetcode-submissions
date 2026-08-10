class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false; 
        int[] arr = new int[26];
        int idx;
        for(int i=0; i<s.length(); i++){
            idx = s.charAt(i) - 'a';
            arr[idx] = arr[idx] + 1;

            idx = t.charAt(i) - 'a';
            arr[idx] = arr[idx] - 1; 
        }

        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != 0) return false;
        }

        return true;
    }
}
