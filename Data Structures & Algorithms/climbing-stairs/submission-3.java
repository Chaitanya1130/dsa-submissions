class Solution {
    public int climbStairs(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(dp[n]!=-1){return dp[n];}
        int one=climbStairs(n-1);
        int two=climbStairs(n-2);
        return dp[n]=one+two;
    }
}
