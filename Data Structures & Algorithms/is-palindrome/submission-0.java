class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        s = s.trim();
        s = s.replaceAll("[^A-Za-z0-9]", "");
                int en = s.length() - 1;
        s = s.toLowerCase();

        while(st<en){
            if(s.charAt(st) != s.charAt(en)) return false;
            st++; en--;
        }
        return true;

    }
}
