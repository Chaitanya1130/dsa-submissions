class Solution {
    private boolean check(char x){
        if(x>='A' && x<='Z'){
            return true;
        }
        else if(x>='a' && x<='z'){
            return true;
        }
        else if(x>='0' && x<='9'){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<=r){
            if(!check(s.charAt(l))){
                l++;
            }
            else if( !check(s.charAt(r))){
                r--;
            }
            else if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
