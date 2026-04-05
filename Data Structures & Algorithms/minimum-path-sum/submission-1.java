class Solution {
    public int minPathSum(int[][] grid) {
        int[][]dp=new int[grid.length+1][grid[0].length+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return help(0,0,grid.length,grid[0].length,grid,dp);
    }
    private int help(int x,int y,int m,int n,int[][]grid,int[][]dp){
        if (x >= m || y >= n) return Integer.MAX_VALUE;
        if (x == m - 1 && y == n - 1) return grid[x][y];
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int right = help(x, y + 1, m, n, grid,dp);
        int down = help(x + 1, y, m, n, grid,dp);
        return dp[x][y]=grid[x][y]+Math.min(right,down);


    }
}