class Solution {
    public int lengthOfLongestSubstring(String s) {
        // we could have a sliding window and shrink it only when a repeating character appeart.s. to find repeating character we cas use a hash set
        if(s.length() == 0 && s.length()<2) return s.length();  // edge casse

        HashSet<Character> set = new HashSet<>();
        int l =0;
        int n = s.length();
        int max =0;

        for(int r=0; r<n; r++){
            while(set.contains(s.charAt(r)) && l<r){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            max = Math.max(max, r-l+1);

        } 
        return max;
    }
}
