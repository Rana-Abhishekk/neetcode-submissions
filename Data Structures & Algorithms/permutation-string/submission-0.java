class Solution {
    public boolean checkInclusion(String s1, String s2) {
                int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // build s1's frequency and the first window of s2
        for (int i = 0; i < len1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (matches(freq1, freq2)) return true;

        // slide the window across s2
        for (int i = len1; i < len2; i++) {
            freq2[s2.charAt(i) - 'a']++;           // add new char entering
            freq2[s2.charAt(i - len1) - 'a']--;    // remove old char leaving
            if (matches(freq1, freq2)) return true;
        }

        return false;
    }
        static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
