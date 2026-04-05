class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        Set<Character>set=new HashSet<>();
        int i=0;
        int j=0;
        int len=0;
        while(j<s.length()){
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            j++;
            len=Math.max(len,j-i+1);
        }
        return len-1;
    }
}
