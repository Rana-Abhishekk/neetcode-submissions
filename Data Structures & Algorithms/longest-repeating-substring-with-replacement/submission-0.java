class Solution {
    public static int findMax(int[] arr){
        int max = 0;
        for(int element : arr){
            max = Math.max(max,element);
        }
        return max;

    }
    
    public int characterReplacement(String s, int k) {
        // we know it needs sliding window we can take low and high pointers , we also need to have the frequency count which will help us determine which character should we replace in the window.
        // we also need to determine the condition under which the window should shrink and it will shrink if windowLen - hFreq > k, then we will reduce the widow and reduce count of chaaracter from hash array . 
        // initializing variables.
        int[] freq = new int[26];
        int res = 0;
        int maxFreq = 0;
        int windowLen = 0; 
        int diff; // difference in windowLen and maxFreq character to determine if its less than k 
        int l = 0;
        int n = s.length();
        // make sure array is initialized as zero data
        for(int r=0; r<n; r++){
            // update information set 
            freq[s.charAt(r) - 'A']++;
            windowLen = r-l+1;
            maxFreq = findMax(freq);
            diff = windowLen - maxFreq;
            // false statement condition and shrinking of window
            while(diff >k){
                freq[s.charAt(l) - 'A']--;
                l++; // other stuff as well
                windowLen = r-l+1;
                // recompute the check for while
                diff = windowLen - findMax(freq);

            }


            // usual case when we have differnt character number smaller than the k given

            res = Math.max(res, r-l+1);

        }

        return res;





    }
}
 