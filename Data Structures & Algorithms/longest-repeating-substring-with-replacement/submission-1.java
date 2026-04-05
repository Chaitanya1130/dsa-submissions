class Solution {
    public int characterReplacement(String string, int k) {
        int maxLength=0;
        int maxFrequency=0;
        int left=0;
        Map<Character,Integer>map=new HashMap<>();
        for(int right=0;right<string.length();right++){
            char currentChar=string.charAt(right);
            if(map.containsKey(currentChar)){
                map.put(currentChar,map.get(currentChar)+1);
            }
            else{
                map.put(currentChar,1);
            }
            maxFrequency=Math.max(maxFrequency,map.get(currentChar));
            int numberOfCharacrectsLefttoReplace=(right-left+1)-maxFrequency;
            if(numberOfCharacrectsLefttoReplace>k){
                char leftChar=string.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                left++;
            }
            maxLength=Math.max(maxLength,(right-left+1));
        }
        return maxLength;
    }
}