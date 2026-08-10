class Solution {
    public boolean isAnagram(String s, String t) {
        // Using hash maps
        Map<Character,Integer> hmS = new HashMap<>();
        Map<Character,Integer> hmT = new HashMap<>();

        // edge case 
        if(s.length() != t.length()) return false;
        Integer valueS ;
        Integer valueT ;

        for(int i=0; i<s.length(); i++){
            if(hmS.containsKey(s.charAt(i))){
                valueS = hmS.get(s.charAt(i));
                hmS.put(s.charAt(i), valueS + 1);
            } else {
                hmS.put(s.charAt(i), 0);
            }

            char ch = t.charAt(i);
            if(hmT.containsKey(ch)){
                valueT = hmT.get(ch);
                hmT.put(ch ,valueT + 1);
            } else {
                hmT.put(ch , 0);
            }
        }

        return hmS.equals(hmT);
    }
}
