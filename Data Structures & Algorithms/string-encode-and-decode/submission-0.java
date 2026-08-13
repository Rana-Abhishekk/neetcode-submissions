class Solution {

    public String encode(List<String> strs) {
        // encoding can be done by counting the no. of character in string and then keeping count followed by hash.g 
        StringBuilder encoded = new StringBuilder(); // we could use stringbuilder as well.
        for(String str : strs){
            int length = str.length();
            String prefix_length = Integer.toString(length);
            encoded.append(prefix_length);
            encoded.append("#");
            encoded.append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        int i =0 ;
        int idx = 0;
        List<String> res = new ArrayList<>();
        
        while(i<str.length()){
            StringBuilder digitS = new StringBuilder();
            idx = i;
            while(str.charAt(idx) != '#'){
                digitS.append(str.charAt(idx));
                idx++;
            }
            // after this while loop idx is at # i will be at starting position .digas only digit itS h
            int digitInt = Integer.parseInt(digitS.toString());

            // we will get hte substring from here.
            i = idx+1; // so i will come at first character after # as idx was at #
            idx = idx + digitInt + 1; // idx will go ahead digitInt times and willl be at last character + 1
            String subString = str.substring(i, idx);
            res.add(subString);
            i = idx;
        }
        return res;
        
    }
}
