class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp=new int[text1.length()+1][text2.length()+1];
        for (int[] row : dp) {
           Arrays.fill(row, -1);
        }
        return help(0,0,text1.length(),text2.length(),text1,text2,dp);
    }
    private int help(int i,int j,int t1,int t2,String text1,String text2,int[][]dp){
        if(i>=t1 || j >=t2){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+help(i+1,j+1,t1,t2,text1,text2,dp);
        }
        else{
            int takei=help(i,j+1,t1,t2,text1,text2,dp);
            int takej=help(i+1,j,t1,t2,text1,text2,dp);
            return dp[i][j]=Math.max(takei,takej);
        }
    }
}
