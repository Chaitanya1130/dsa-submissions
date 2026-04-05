class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp=new int[m+1][n+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return help(0,0,m,n,dp);
    }
    private int help(int x,int y,int m,int n,int [][]dp){
        if (x >= m || y >= n) return 0;
        if (x == m - 1 && y == n - 1) return 1;
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int right=help(x,y+1,m,n,dp);
        int down=help(x+1,y,m,n,dp);
        return dp[x][y]=right+down;
    }
}
