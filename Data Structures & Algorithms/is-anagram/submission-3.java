class Solution {
    public boolean isAnagram(String s, String t) {
        // Using hash maps
        Map<Character,Integer> hmS = new HashMap<>();
        Map<Character,Integer> hmT = new HashMap<>();

        // edge case 
        if(s.length() != t.length()) return false;
        for(int i=0 ; i< s.length(); i++){
            hmS.put(s.charAt(i), hmS.getOrDefault(s.charAt(i), 0) + 1); 
            hmT.put(t.charAt(i), hmT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return hmS.equals(hmT);
    }
}
