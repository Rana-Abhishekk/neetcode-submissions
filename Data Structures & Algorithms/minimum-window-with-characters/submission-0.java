class Solution {
    public String minWindow(String s, String t) {
        // we need to use min sliding window which is dynamic window , we will use freq array to keep cound of string and can compare for each substring count of window freq array elements should be >= count of t string freq array.
        int l = 0 ;
        int start = 0; // start and len is requierd to find the substring
        int len = 0;
        int minLen=Integer.MAX_VALUE;
        int[] freqS = new int[256];
        int[] freqT = new int[256];
        // fill freqT
        for(int i=0; i<t.length(); i++){
            freqT[t.charAt(i)]++;
        }

        // we will compare the array we will vuild with windrow from s and the substring shall be min.
        for(int r=0; r<s.length(); r++){
            // add r to the freq array
            freqS[s.charAt(r)]++;

            // true condition
            while(compare(freqS, freqT)){
                len = r-l+1;
                if (len < minLen) {
                minLen = len;
                start = l;
}
                // update the window now shrink it 
                freqS[s.charAt(l)]--;
                l++;
            } 

        }
        if (minLen == Integer.MAX_VALUE) return "";

        return s.substring(start, start+minLen);

    }
    static Boolean compare(int[] freqS, int[] freqT){
        for(int i=0; i<256; i++){
            if(freqS[i] < freqT[i]) return false;
        }
        return true;
    }
}
