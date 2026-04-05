class Solution {
    public String longestPalindrome(String s) {
        int tot=0,start=0;
       for (int i=0;i<s.length();i++){
        int l=i,r=i;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            int winlen=r-l+1;
            if(winlen>tot){
                tot=winlen;
                start=l;
            }
            l--;
            r++;
        }
        l=i;r=i+1;
        while(l>=0 && r<s.length()&&s.charAt(l)==s.charAt(r)){
            int win=r-l+1;
            if(win>tot){
                tot=win;
                start=l;
            }
            l--;
            r++;
        }
       }
       return s.substring(start, start + tot);
    }
}
