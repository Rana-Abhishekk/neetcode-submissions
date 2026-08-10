class Solution {
    public boolean isAnagram(String s, String t) {
        // could be an edge case of differnt size.
        if(s.length() != t.length()) return false;
        //Brute Force 
        // sort both strings and then compare.
        char[] arrS = s.toCharArray();  // it stores in form of ascii
        char[] arrT = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        for(int i=0; i<arrS.length; i++){
            if(arrS[i] != arrT[i]) return false;
        }  
        return true;

    }
}
