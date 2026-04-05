class Solution {
    boolean palcheck(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(palcheck(s,i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }
}
