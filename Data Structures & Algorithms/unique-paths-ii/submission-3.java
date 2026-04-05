class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        if (arr[0][0] == 1) {
            return 0;
        }
        int[][]dp=new int[arr.length+1][arr[0].length+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return help(0,0,arr.length,arr[0].length,arr,dp);
    }
    private int help(int x,int y,int m,int n,int[][]arr,int[][]dp){
        
        if (x >= m || y >= n) return 0;
        if (x == m - 1 && y == n - 1) return 1;
        if(arr[x][y]==1)return 0;
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int right=0,down=0;
        right=help(x,y+1,m,n,arr,dp);
        down=help(x+1,y,m,n,arr,dp);
      
        return dp[x][y]=right+down;
    }
}